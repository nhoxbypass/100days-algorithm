import random

#generate 20 number from 0-30
def generate_input():
	return random.sample(range(30), 20) 


# This is method to support create a min binary heap
# create max heap from unsorted array
def build_binary_heap(heap):
    n = len(heap) // 2

    # Loop thru all node except the leaves
    for i in reversed(range (0, n)):
        heapifyDown(heap, len(heap), i)


def push(heap, value):
    current_len = len(heap) # Get the current length of heap array
    heap.append(value)
    heapifyUp(heap, current_len) # Shift item at current length up to re-order the heap

def pop(heap):
    n = len(heap)
    item = heap[0] # Get the item to pop out of the heap
    heap[0] = heap[n - 1] # Assign new root node by the last/newest item in the heap

    # Recursively heapify the affected sub-tree
    heapifyDown(heap, n - 1, 0) # Shift item at root node down to re-order the heap

    return item

# Compare the node at position with it's root and swap if it's bigger
# To ensure the parent node always bigger than it's child nodes
def heapifyUp(heap, position):
    while True:
        # Get the index of parent node
        parent_index = getParentNodeIndex(position)
       
        # Ensure the index not negative
        if parent_index < 0:
            parent_index = 0
    
        # Because it's max heap, every parent must be bigger than it's child nodes
        # So if it smaller, swap the bigger node to the parent node
        if heap[parent_index] < heap[position]:
            swap(heap, parent_index, position)
        else:
            # If the parent is already bigger, and we assume the rest of the heap is already in-place
            # So we can end the heapify
            return

        # We already reach the root node, and after heapify it, we end the heapify
        if parent_index == 0:
            return

# Compare the parent node at position with it's child nodes
# Swap and move down to the next parent node if it's smaller than it's child nodes
# Only heapify down to the limit bound given (to reserve the sorted part)
def heapifyDown(heap, bound, position):
    idx = position
    while True:
        # Get parent node
        parent_node = heap[idx]

        # If this node has child
        if haveLeftChild(heap, bound, idx):
            # Find the biggest child node
            biggest_idx = getLeftChildIndex(idx)
            
            # If this node also has right child, compare the left node and right node to get the biggest child node
            if haveRightChild(heap, bound, idx) and heap[biggest_idx] < heap[getRightChildIndex(idx)]:
                biggest_idx = getRightChildIndex(idx)

            # Compare the parent node with the biggest child node
            if parent_node < heap[biggest_idx]:
                swap(heap, idx, biggest_idx) # Swap if child node bigger than the node
                idx = biggest_idx # Get the index to continue move down in the heap
            else:
                # Assume that the rest part of the node is already in-place
                # End the heapify
                return
        else:
            # If we reach the leave, end the heapify
            return

def heapsort(heap):
    # Build the binary heap (rearrange array)
    build_binary_heap(heap)
    
    print(" - After build heap: ")
    print(heap)

    # One by one extract a biggest element from heap
    for i in reversed(range(0, len(heap))):
        # Swap the root node and the last element which will move the biggest element to end
        swap(heap, 0, i)

        # Recursively heapify down the affected sub-tree
        heapifyDown(heap, i, 0)
       

        
# We explicit givee the size because sometimes it is inside the heap array but not part of the binary heap
def haveLeftChild(heap, size, position):
    if size <= len(heap) and 2*position + 1 < size:
        return True
    return False

def haveRightChild(heap, size, position):
    if size <= len(heap) and 2*position + 2 < size:
        return True
    return False

def getLeftChildIndex(position):
    return 2*position + 1

def getRightChildIndex(position):
    return 2*position + 2

def getParentNodeIndex(position):
    return (position - 2) // 2
        
#Swap items with index i,j inside array
def swap(array, i, j):
	array[i], array[j] = array[j], array[i]


# Test method
def isMaxHeap(heap, pos, size):
    # If a leaf node
    if pos > (size - 2) / 2:
        return True

    # If an internal node and is smaller than its children, and
    # same is recursively true for the children
    if heap[pos] >= heap[2*pos + 1] and heap[pos] >= heap[2*pos + 2] and isMaxHeap(heap, 2*pos + 1, size) and isMaxHeap(heap, 2*pos + 2, size):
        return True
    return False
        

# Run
heap = generate_input()
print(" - Data: ")
print(heap)

build_binary_heap(heap)
print(" - Heapify: ")
print(heap)

print(" - Check is max heap: " + str(isMaxHeap(heap, 0, len(heap) - 1)))

# Test heap sort
heap = generate_input()
print("\n - Data: ")
print(heap)

heapsort(heap)
print(" - Heap sort: ")
print(heap)