import random

# A Python class that represents an individual node 
# in a Binary Tree

INT_MAX = 4294967296
INT_MIN = -4294967296

class Node:
	def __init__(self,key):
		self.left = None
		self.right = None
		self.val = key

	def __str__(self):
		res = "Val: " + str(self.val)
		if self.haveLeftChild():
			res = res + ". Left: " + str(self.left.val)
		if self.haveRightChild():
			res = res + ". Right: " + str(self.right.val)
			
		return res

	def haveLeftChild(self):
		if self.left is None:
			return False
		return True

	def haveRightChild(self):
		if self.right is None:
			return False
		return True

class BinarySearchTree:
	def __init__(self):
		self.root = None

	# A utility function to insert a new node with the given key
	def insertTo(self, parent, node):
		if parent.val > node.val:
			if parent.haveLeftChild():
				self.insertTo(parent.left, node)
			else:
				parent.left = node
			
		elif parent.val < node.val:
			if parent.haveRightChild():
				self.insertTo(parent.right, node)
			else:
				parent.right = node
			
	# Method to for quick use without give the tree root node    
	def insert(self, value):
		# If the tree is empty
		if self.root is None:
			self.root = Node(value)
		else:
			self.insertTo(self.root, Node(value))

	def search(self, value):
		return self.searchAt(self.root, value)


	def searchAt(self, parent, value):
		# Base Cases: parent node is null or key is present at parent node
		if parent == None:
			return None

		if parent.val == value:
			return parent
		
		if parent.val > value:
			# Key is smaller than root's key
			return self.searchAt(parent.left, value)
		elif parent.val < value:
			# Key is greater than root's key
			return self.searchAt(parent.right, value)

	# Search without recursion	
	def search_iteratively(key, node): 
		current_node = node
		while current_node is not None:
			if key == current_node.key:
				return current_node
			if key < current_node.key:
				current_node = current_node.left
			else: # key > current_node.key:
				current_node = current_node.right
		return current_node
		
	# Given a binary search tree and a key, this function
	# delete the key and returns the new root
	def deleteAt(self, parent, value):
		# Base Case
		if parent is None:
			return parent
		
		# If key is same as root's key, then this is the node
		# to be deleted
		if parent.val == value:
			# Node with only one child or no child
			if parent.haveLeftChild() and not parent.haveRightChild():
				# If there is only left child
				temp = parent.left
				parent = None
				return temp 
			if not parent.haveLeftChild() and parent.haveRightChild():
				# If there is only right child
				temp = parent.right
				parent = None
				return temp
			if not parent.haveLeftChild() and not parent.haveRightChild():
				# No child node
				parent = None
				return None
			else:
				# Node with two children: Get the inorder successor
				# (smallest in the right subtree)
				# Because the min node in the right subtree is bigger than every node in the left subtree
				# And it is smaller than the rest node in the right subtree
				# So it suitable to be new parent node
				temp = self.minValueNode(parent.right)
				
				# Copy the inorder successor's content to this node
				# Instead if swap entire node, we copy value
				parent.val = temp.val

				# Delete the temp node
				# Use parent.right as the parent node to avoid delete current parent node
				# Because we've just copy the same value from temp node to parent
				parent.right = self.deleteAt(parent.right , temp.val)
		
		if value < parent.val:
			# If the key to be deleted is similiar than the root's
			# key then it lies in  left subtree
			parent.left = self.deleteAt(parent.left, value)
		elif value > parent.val:
			# If the kye to be delete is greater than the root's key
   			 # then it lies in right subtree
			parent.right = self.deleteAt(parent.right, value)
		
		return parent

	def delete(self, value):
		return self.deleteAt(self.root, value)

	# Display the BST in increasing order
	def display(self):
		self.displayAt(self.root)

	def displayAt(self, node):
		if node is not None:
			self.displayAt(node.left)
			print(" " + str(node))
			self.displayAt(node.right)

	# Given a non-empty binary search tree, return the node
	# with minum key value found in that tree. Note that the
	# entire tree does not need to be searched 
	def minValueNode(self, node):
		current = node
 
		# loop down to find the leftmost leaf
		while(current.left is not None):
			current = current.left 
		return current
			

#generate 20 number from 0-17
def generate_input():
	random_array = random.sample(range(17), 17)
	return random_array

def sort(array):
	tree = BinarySearchTree()
	
	# Create tree
	for i in range(0, len(array)):
		tree.insert(array[i])

	array.clear()
	get_inorder_traversal(array, tree.root)
	

def get_inorder_traversal(array, parent):
	if parent is not None:
		get_inorder_traversal(array, parent.left)
		array.append(parent.val)
		get_inorder_traversal(array, parent.right)

def storeBSTNodes(array, parent):
	if parent is not None:
		storeBSTNodes(array, parent.left)
		array.append(parent)
		storeBSTNodes(array, parent.right)

# This functions converts an unbalanced BST to a balanced BST
def balanceTree(node):
	# Store nodes of given BST in sorted order
	nodes = []
	storeBSTNodes(nodes, node)

	n = len(nodes)
	return balanceTreeUtil(nodes, 0, n - 1)

# Recursive function to construct binary tree
def balanceTreeUtil(nodes, start, end):
	if start > end:
		return None

	# Get the middle element and make it root
	mid = (start + end) // 2
	node = nodes[mid]

	# Using index in Inorder traversal, construct left and right subtress
	node.left = balanceTreeUtil(nodes, start, mid - 1)
	node.right = balanceTreeUtil(nodes, mid + 1, end)

	return node


# TEST
# Returns true if the given tree is a binary search tree
# (efficient version)
def isBST(node):
	return (isBSTUtil(node, INT_MIN, INT_MAX))
 
# Retusn true if the given tree is a BST and its values
# >= min and <= max
def isBSTUtil(node, mini, maxi):
	# An empty tree is BST
	if node is None:
		return True
 
	# False if this node violates min/max constraint
	if node.val < mini or node.val > maxi:
		return False
 
	# Otherwise check the subtrees recursively
	# tightening the min or max constraint
	return (isBSTUtil(node.left, mini, node.val -1) and
		  isBSTUtil(node.right, node.val + 1, maxi))

# Running
# Driver program to test above functions
# Let us create following BST
#                 8
#            /         \
#           4          12
#         /   \       /   \
#       2     6      10    14
#      /  \  /  \   /  \  /  
#	  1   3  5  7  9   11 13 

# Uncomment if you want to use random dynamic value
# tree = generate_input()
# tree = BinarySearchTree()
#	for item in random_array:
#		tree.insert(item)
#
#	return tree

tree = BinarySearchTree()
tree.insert(8)
tree.insert(4)
tree.insert(2)
tree.insert(1)
tree.insert(3)
tree.insert(6)
tree.insert(5)
tree.insert(7)
tree.insert(12)
tree.insert(10)
tree.insert(9)
tree.insert(11)
tree.insert(14)
tree.insert(13)

print(" - Display: ")
tree.display()

check = isBST(tree.root)
print(" - Check: " + str(check))

node = tree.search(6)
print(" - Find 6: " + str(node))

tree.delete(1)
print(" - Delete 1: ")
tree.display()

tree.delete(14)
print(" - Delete 14: ")
tree.display()

tree.delete(4)
print(" - Delete 4: ")
tree.display()

print(" - Random array: ")
array = generate_input()
print(array)

sort(array)
print(" - Sorted: ")
print(array)

print(" - Unbalanced BST: ")
array.clear()
array = generate_input()
tree = BinarySearchTree()
for item in array:
	tree.insert(item)

print(" - Display: ")
tree.display()

print(" - Balance: ")
tree.root = balanceTree(tree.root)
tree.display()