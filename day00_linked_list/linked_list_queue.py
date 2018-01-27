import random
import gc

# Doubly node for support doubly linked list
class Node:
	val = -1
	def __init__(self, val):
		self.val = val
		# the pointer to next node and previous node initially points to nothing
		self.prev = None
		self.next = None

	def __str__(self):
		return str(self.val)

	def __str__(self):
		return str(self.val)

	def __eq__(self, other): 
		return self.val == other.val


# This linked list implemented that we always insert to after the TAIL
# Some kind like FIFO
class Queue:
	def __init__(self):
		# the pointer to head node initially points to nothing
		self.head = None
		self.tail = None

	def traversal(self):
		current_node = self.tail
		while current_node is not None:
			print(current_node.val)
			current_node = current_node.next

	# The add item flow is: new item --enqueue--> TAIL --> item --> item --> HEAD
	# Inserts the specified element into this queue if it is possible to do so immediately without violating capacity restrictions
	def enqueue(self, data):
		node = Node(data)
		if self.tail is None:
			# The linked list currently empty
			# Because it's first node, we set prev and next ptr of this node to None
			# which already done in Node() constructor
			self.head = node
			self.tail = node
		else:
			# The linked list already have items
			node.next = self.tail # new node --next--> TAIL
			self.tail.prev = node # new node <--prev-- TAIL

			# new node become new TAIL: move the head ptr to the new node
			# new TAIL <=> old TAIL <=> other nodes (if exists)...
			self.tail = node

	# The remove item flow is: TAIL --> item --> item --dequeue--> HEAD
	# Retrieves and removes the head of this queue.
	def dequeue(self):
		res = None
		if self.head is None:
			# There is nothing left to dequeue
			res = None
		else:
			res = self.head
			temp = self.head.prev # Previous node of HEAD

			# Assign new refs
			temp.next = self.head.next # Ussually None
			self.head.prev = None
			self.head.next = None

			# Set new HEAD
			self.head = temp
		
		# Finally, free the memory occupied by dele
		# Call python garbage collector
		gc.collect()

		return res

	# Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
	def peek(self):
		return self.head

	# Removes and returns the head of the queue. Returns null if queue is empty.
	def poll(self):
		return self.dequeue()

	# Returns the number of elements in this collection.
	def size(self):
		current_node = self.head
		size = 1

		# Iterate to end of the queue to find it's size
		while current_node is not None:
			size += 1
			current_node = current_node.next

		return size

	# Returns true if this collection contains no elements.
	def isEmpty(self):
		if self.head is None:
			return False

		return True


#generate 20 number from 0-30
def generate_input():
	random_array = random.sample(range(30), 20)
	list = Queue()
	for item in random_array:
		list.enqueue(Node(item))

	return list


# Running
print("\n - Data: ")
list = generate_input()
list.traversal()

print("\n - Enqueue node with value = 99: ")
list.enqueue(99)
list.traversal()

print("\n - Dequeue: ")
node = list.dequeue()
print("Node " + str(node) + " is dequeued")
list.traversal()

print("\n - Peek: ")
node = list.peek()
print("Node " + str(node) + " is peeked")
list.traversal()

print("\n - Poll: ")
node = list.poll()
print("Node " + str(node) + " is polled")
list.traversal()