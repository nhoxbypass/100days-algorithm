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

# This linked list implemented that we always insert and remove element at before the HEAD
# Some kind like FILO
class Stack:
    def __init__(self):
        # the pointer to head node initially points to nothing
        self.head = None

    def traversal(self):
        current_node = self.head
        while current_node is not None:
            print(current_node.val)
            current_node = current_node.next

    # Pushes an item onto the top of this stack.
    # The flow is: item <- item <- item <- HEAD <--push-- new item
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

    # Removes the object at the top of this stack and returns that object as the value of this function.
    # The flow is: item <- item <- item <--pop-- HEAD
    def pop(self):
        res = None
        if self.head is None:
            # There is nothing left to delete
            res = None
        else:
            res = self.head
            temp = self.head.next # Next node of HEAD

            # Assign new refs
            temp.prev = self.head.prev # Ussually None
            self.head.prev = None
            self.head.next = None

            # Set new HEAD
            self.head = temp
        
        # Finally, free the memory occupied by dele
        # Call python garbage collector
        gc.collect()

        return res

    # Looks at the object at the top of this stack without removing it from the stack.
    def peek(self):
        return self.head

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
    list = Stack()
    for item in random_array:
        list.push(Node(item))

    return list


# Running
print("\n - Data: ")
list = generate_input()
list.traversal()

print("\n - Push node with value = 99: ")
list.push(99)
list.traversal()

print("\n - Pop: ")
node = list.pop()
print("Node " + str(node) + " is poped")
list.traversal()

print("\n - Peek: ")
node = list.peek()
print("Node " + str(node) + " is peeked")
list.traversal()