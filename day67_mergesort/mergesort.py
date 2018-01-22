import random
import math

#generate 20 number from 0-30
def generate_input():
    return random.sample(range(30), 20)

def clone_array(array):
    return list(array)

def merge(array, begin, middle, end):
    # create temp arrays
    tmp_arr = clone_array(array)

    # Merge the temp arrays back into array[begin..end]
    i = begin # Initial index of first subarray
    j = middle + 1 # Initial index of second subarray
    k = begin # Initial index of merged subarray

    while i <= middle and j <= end:
        # Compare smaller or equal (<=) to keep the sort stable
        if tmp_arr[i] <= tmp_arr[j]:
            array[k] = tmp_arr[i]
            i += 1
        else:
            array[k] = tmp_arr[j]
            j += 1
        k += 1
    
    # Copy the remaining elements of left part, if there are any
    while i <= middle:
        array[k] = tmp_arr[i]
        k += 1
        i += 1
    
    # Copy the remaining elements of right part, if there are any
    while j <= end:
        array[k] = tmp_arr[j]
        k += 1
        j += 1


# begin is for left index and end is right index of the sub-array of arr to be sorted
def mergesort(array, begin, end):
    if begin < end:
        # Find the middle point
        middle = math.floor((begin + end) / 2)

        # Sort first and second halves
        mergesort(array, begin, middle)
        mergesort(array, middle + 1, end)

        # Merge the sorted halves
        merge(array, begin, middle, end)

#Run
array = generate_input()
print("Array: ")
print(array)

print("-------------------------------------")

mergesort(array, 0, len(array) - 1)
print("\n Sorted array: ")
print(array)
