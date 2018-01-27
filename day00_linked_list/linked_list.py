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

# This linked list implemented that we always insert to before the HEAD
class LinkedList:
	def __init__(self):
		# the pointer to head node initially points to nothing
		self.head = None

	def traversal(self):
		current_node = self.head
		while current_node is not None:
			print(current_node.val)
			current_node = current_node.next

	def push(self, data):
		node = Node(data)
		if self.head is None:
			# The linked list currently empty
			# Because it's first node, we set prev and next ptr of this node to None
			# which already done in Node() constructor
			self.head = node
		else:
			# The linked list already have items
			self.head.prev = node # new node <- HEAD
			node.next = self.head # new node -> HEAD

			# new node become new HEAD: move the head ptr to the new node
			# new HEAD <=> old HEAD <=> other nodes (if exists)...
			self.head = node

	def insertAfter(self, prevNode, data):
		pass

	def insertBefore(self, nextNode, data):
		pass

	def delete(self, deleted_node):
		if self.head is None or deleted_node is None:
			# There is nothing left to delete
			pass
		elif deleted_node == self.head:
			next_node = self.head.next
			if next_node is not None:
				# Apply new HEAD ptr to the next node of current HEAD
				next_node.prev = None
				self.head.next = None
				self.head = next_node
			else:
				# Clear HEAD ptr if this is the only node in linked list
				self.head = None
		else:
			prev_node = deleted_node.prev # because this node is not HEAD, so previous node will NOT be None
			next_node = deleted_node.next # next node could be None

			# Attach new reference
			prev_node.next = next_node
			if next_node is not None:
				next_node.prev = prev_node

			# Clear references of deleted node
			deleted_node.prev = None
			deleted_node.next = None
		
		# Finally, free the memory occupied by dele
		# Call python garbage collector
		gc.collect()


	# Function reverse a Doubly Linked List
	def reverse(self):
		current_node = self.head
		while current_node.next is not None:
			# Get next node
			next_node = current_node.next

			# Update new references by swapping prev and next ptr
			temp = current_node.prev
			current_node.prev = current_node.next
			current_node.next = temp

			# Assign new value an continue the loop
			current_node = next_node

		# Current node is the (ex) tail node
		# Convert to head node to complete the reverse
		current_node.next = current_node.prev
		current_node.prev = None
		self.head = current_node

#generate 20 number from 0-30
def generate_input():
	random_array = random.sample(range(30), 20)
	list = LinkedList()
	for item in random_array:
		list.push(item)

	return list


# Running
print(" - Data: ")
list = generate_input()
list.traversal()

print(" - Push node with value = 99: ")
list.push(99)
list.traversal()

print(" - Delete: ")
list.delete(list.head.next)
list.traversal()

print(" - Reverse: ")
list.reverse()
list.traversal()