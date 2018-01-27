import random

#generate 20 number from 0-30
def generate_input():
	return random.sample(range(30), 20) 

#Swap items with index i,j inside array
def swap(array, i, j):
	array[i], array[j] = array[j], array[i]

# Normal bubble sort with flag optimize
def bubblesort(array):
	# Use to detect whether all items is already sorted, this also an optimize
	# Without this flag, we must use nested loop to sort
	# even the array is already sorted, it continue run until complete 2 loop
	swapped = True

	while swapped:
		swapped = False # Reset flag

		# Traverse through array to compare adjacent items
		for i in range(0, len(array) - 1):
			# Swap if found the item appear before another, but smaller
			if array[i] > array[i+1]:
				swap(array, i, i+1)
				swapped = True # Turn on the flag

# Optimized bubble sort
def bubblesort_optimized_1(array):
	for i in range(0, len(array) - 1):
		swapped = False

		# Last i elements are already in place
		# So we decrease the number the loop have to run run to i
		# Because we compare each pair -> the bigger item always be swap to the right
		# So with each loop, the biggest item in range [0, n-i] will be moved to the last position of this part (position n-i-1)    
		for j in range(0, len(array) - i - 1):
			if array[j] > array[j+1]:
				swap(array, j, j+1)
				swapped = True

		# Break if  the array is already sorted
		if not swapped:
			break


#Run
array = generate_input()
print("Array: ")
print(array)

bubblesort(array)
print("\n Sorted array: ")
print(array)

# Optimizing 1
array_1 = generate_input()
print("\nArray 1: ")
print(array_1)

bubblesort_optimized_1(array_1)
print("\n Sorted array 1: ")
print(array_1)