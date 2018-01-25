import random

#generate 20 number from 0-30
def generate_input():
	return random.sample(range(30), 20) 

#Swap items with index i,j inside array
def swap(array, i, j):
	array[i], array[j] = array[j], array[i]


def selectionsort(array):
	# Traverse from 0 to end to sub the array into sorted/unsorted part 
	i = 0
	while i < (len(array) - 1):
		# Get the index of smallest item in the unsorted subarray [i:(len-1)]
		s = find_smallest(array, i)
		# Swap smallest item to the first place of unsorted subarray
		swap(array, s, i)
		i += 1

def find_smallest(array, begin):
	min_idx = begin
	min = array[begin]
	for i in range(begin + 1, len(array)):
		if min > array[i]:
			# Found new min
			min = array[i]
			min_idx = i
	
	return min_idx

#Run
array = generate_input()
print("Array: ")
print(array)

selectionsort(array)
print("\n Sorted array: ")
print(array)