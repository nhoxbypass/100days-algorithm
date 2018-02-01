import random
from types import SimpleNamespace

class Node:
	def __init__(self, _key, _value, _next, _entry_next, _entry_prev):
		self.key = _key
		self.value = _value
		self.next = _next
		self.entry_next = _entry_next
		self.entry_prev = _entry_prev

class HashTable:
	EXPAND_RATIO = 0.7
	SHRINK_RATIO = 0.2
	MIN_SIZE = 11 # Default min size
	size = 0
	capacity = 11

	# Constructor (Initializes capacity, size and empty chains.
	def __init__(self, _cap=None):
		self.capacity = _cap or self.MIN_SIZE # If don't explicit set capacity -> capacity = min size
		self.buckets = [None] * self.capacity # Create empty chains
		self.list = None
		self.size = 0

	# Get hash table current size
	def getSize(self):
		return self.size

	# Check hash table empty
	def isEmpty(self):
		if self.size == 0:
			return True
		return False

	# This implements hash function to find index, entry, previous entry for a key
	def getIndexAndEntry(self, key):
		# get hash and convert to index
		idx = hash(key) % self.capacity
		
		# find entry by key
		p = self.buckets[idx] # Get the chain inside the bucket at index
		q = None
		# Loop to the end to find key
		while p is not None and p.key != key:
			q = p # Get prev entry
			p = p.next # Move to next item
			
		# index, entry, previous entry
		return idx, p, q

	# Returns value for a key
	def get(self, key):
		_, p, _ = self.getIndexAndEntry(key)
		return p and p.value

	# Adds a key value pair to hash
	def add(self, key, value):
		# Find if key exist in table
		idx, p, _ = self.getIndexAndEntry(key)
		
		# set entry if key was found
		if p is not None:
			p.value = value
			return
		
		# Not found, create new entry
		p = Node(key, value, self.buckets[idx], self.list, None)

		# store to bucket
		self.buckets[idx] = p
		
		# store to list
		if self.list is not None:
			self.list.entry_prev = p
		self.list = p
		
		# expand table
		self.size += 1
		self.ensure_capacity()

	# Method to remove a given key
	def remove(self, key):
		idx, p, q = self.getIndexAndEntry(key)
		# key not found
		if p is None:
			return
		
		# Found, remove from bucket
		if q is not None:
			q.next = p.next # prev --> todelete --> todelete.next (turn into) prev --> todelete.next
		else:
			# If todelete is the head item of the chain
			self.buckets[idx] = p.next
		
		# remove p from list
		if p.entry_next is not None:
			p.entry_next.entry_prev = p.entry_prev
		if p.entry_prev is not None:
			p.entry_prev.entry_next = p.entry_next
		else:
			self.list = p.entry_next
		
		# shrink
		self.size -= 1
		self.ensure_capacity()

	# Method to check if table contain key
	def contains(self, key):
		_, p, _ = self.getIndexAndEntry(key)
		return bool(p)

	# Iterator through the table
	def __iter__(self):
		p = self.list
		while p:
			yield p.key
			p = p.entry_next

	# Increase capacity if the size reach the expand ratio
	def ensure_capacity(self):
		# Filled percentage
		fill = self.size / self.capacity
		
		# expand or shrink?
		if fill > self.EXPAND_RATIO:
			self.capacity = self.capacity * 2 + 1 # New capacity
		elif fill < self.SHRINK_RATIO and \
				self.capacity > self.MIN_SIZE:
			self.capacity = (self.capacity - 1) // 2 # New capacity
		else:
			return
		
		# reallocate buckets
		self.buckets = [None] * self.capacity
		
		# store entries into new buckets
		p = self.list
		while p:
			idx = hash(p.key) % self.capacity
			p.next = self.buckets[idx]
			self.buckets[idx] = p
			p = p.entry_next

	def slots(self):
		return ''.join(p and 'x' or '-' for p in self.buckets)

# Run
table = HashTable()

# add random values
for _ in range(1000):
	key, value = random.randint(0, 1000), random.random()
	table.add(key, value)

print(" - Size: ")
print(str(table.getSize()))
print(" - Capacity: ")
print(str(table.capacity))
print(" - Slots")
print(table.slots())

# print some values
print(" - Print some values: ")
for key in list(table)[:5]:
    print(key, table.get(key))

# delete all the values
print(" - Delete all values: ")
for key in list(table):
	table.remove(key)

print(" - Size: ")
print(str(table.getSize()))
print(" - Capacity: ")
print(str(table.capacity))
print(" - Slots")
print(table.slots())