import random

#generate 20 number from 0-30
def generate_input():
    return random.sample(range(30), 20) 


#Swap items with index i,j inside array
def swap(array, i, j):
    array[i], array[j] = array[j], array[i]


# Partition
# This function takes LAST element as pivot, places
# the pivot element at its correct position in sorted
# array, and places all smaller (array[j] < pivot)
# to left of pivot and all greater elements to right
# of pivot
def partition(array, start, end):
    pivot = array[end] #Choose last element as pivot
    i = start - 1 # 'i' will be index of the current partition wall
    j = start
    while j < end:
        # If current element is smaller than or equal to pivot
        if array[j] < pivot:
            i += 1
            swap(array, i, j) # Swap the smaller item to the left of the partition wall
        j += 1
    
    # Swap current partition wall item with the pivot (item at end index is the pivot)
    i += 1
    swap(array, i, end) 

    # Return the current index of the pivot
    return i 

# Quick sort
# The main function that implements QuickSort
# array[] --> Array to be sorted,
# begin  --> Starting index,
# end  --> Ending index
def quicksort(array, begin, end):
    if begin < end:
        # pivot index is partitioning index, array[pivot_index] is now at right place
        pivot_index = partition(array, begin, end) #Find pivot, re-arrange and partition

        # Separately sort elements before
        # partition and after partition (but not touching the element at pivot index)
        quicksort(array, begin, pivot_index - 1)
        quicksort(array, pivot_index + 1, end)


#Run
array = generate_input()
print("Array: ")
print(array)

quicksort(array, 0, len(array) - 1)
print("\n Sorted array: ")
print(array)