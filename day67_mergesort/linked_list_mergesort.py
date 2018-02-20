import random

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

def merge(p, q):
	r, s = [Node(0)] * 2
	
	while p is not None and q is not None:
		if p.val < q.val:
			r.next = p
			r = r.next
			p = p.next
		else:
			r.next = q
			r = r.next
			q = q.next

	# Copy remaining part of two list
	while p is not None:
		r.next = p
		r = r.next
		p = p.next

	while q is not None:
		r.next = q
		r = r.next
		q = q.next

	return s.next

def mergesort_recursive(head):
	# Base case : if head is null
	if head is None or head.next is None:
		return head

	# make equal split
	mid_node = get_middle(head)
	next_node = mid_node.next
	
	mid_node.next = None # Break the list into two part

	# sort recursively
	# Apply mergeSort on left list
	left = mergesort_recursive(head)
	# Apply mergeSort on right list
	right = mergesort_recursive(next_node)
	# merge
	return merge(left, right)

def get_middle(head):
	# Base case
	if head is None:
		return head

	p_fast = head.next
	p_slow = head

	# Move fastptr by two and slow ptr by one
	# Finally slowptr will point to middle node
	while p_fast is not None:
		p_fast = p_fast.next
		if p_fast is not None:
			p_fast = p_fast.next
			p_slow = p_slow.next

	return p_slow

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

print(" - Sorted: ")
mergesort_recursive(list.head)
list.traversal()