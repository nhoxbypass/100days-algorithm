import random

#generate 20 number from 0-30
def generate_input():
	return random.sample(range(30), 20) 

#Swap items with index i,j inside array
def swap(array, i, j):
	array[i], array[j] = array[j], array[i]

def insertionsort(array):
	for i in range(0, len(array)):
		# Store current item temporary, because it will be over written when shift the array
		key = array[i] 

		# Begin the find the right place to put 'key', begin from j = i - 1 back to beginning of array
		j = i - 1

		# Move elements of arr[0..i-1], that are greater than key, 
		# to one position ahead of their current position
		while j >= 0 and array[j] > key:
			# Shift the array to 1 position to the end of array
			array[j + 1] = array[j]
			j -= 1

		# Current array[j] is smaller or equals to key
		# So we use j + 1 to made sure it's in the right place even in equality case
		array[j + 1] = key


#Run
array = generate_input()
print("Array: ")
print(array)

insertionsort(array)
print("\n Sorted array: ")
print(array)