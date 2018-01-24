# Doubly node for support doubly linked list
class Node:
    def __init__(self,val):
        self.val = val
        # the pointer to next node and previous node initially points to nothing
        self.prev = None
        self.next = None 

# This linked list implemented that we always insert to before the HEAD
# Some kind like FIFO
class LinkedList:
    def __init__(self):
        # the pointer to head node initially points to nothing
        self.head = None

	def traversal(self):
		node = self.head
		while node.next is not Node:
			print(" - " + str(node.val))

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
		else if deleted_node == self.head:
			# Clear head ptr
			self.head = None
		else:
			Node prev_node = deleted_node.prev # because this node is not HEAD, so previous node will NOT be None
			Node next_node = deleted_node.next # next node could be None
			
			# Attach new reference
			prev_node.next = next_node
			if next_node is not None:
				next_node.prev = prev_node

			# Clear references of deleted node
			deleted_node.prev = None
			deleted_node.next = None


	def reverse(self):
		node = self.head
		while node.next is not None:
			# Get next node
			next_node = node.next 

			# Update new references
			node.prev = next_node
			next_node.next = node

			# Assign new value an continue the loop
			node = next_node
		
		# Current node is the (ex) tail node
		# Convert to head node to complete the reverse
		self.head = node

#generate 20 number from 0-30
def generate_input():
    random_array = random.sample(range(30), 20)
	list = LinkedList()
	for item in random_array:
		list.push(Node(item))
	
	return list


# Running
list = generate_input()
list.traversal()