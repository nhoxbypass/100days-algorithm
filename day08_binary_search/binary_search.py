import random

#generate 20 number from 0-30
def generate_input():
	return random.sample(range(30), 20)

	return array 

# Search item using recursive call
def search(array, start, end, item):
	# If start > end but still not found item
	# Return -1
	if start > end:
		return -1

	# Get the middle index between start - end
	mid = (end + start) // 2
	
	# If found return the index
	if array[mid] == item:
		return mid

	# Because the array is sorted
	if item < array[mid]:
		# If item still smaller than mid element
		# Recursive call to search in the left part of the array
		return search(array, start, mid - 1, item)
	if item > array[mid]:
		# If item still bigger than mid element
		# Recursive call to search in the right part of the array
		return search(array, mid + 1, end, item)

# Search item without recursive
def search_no_recursive(array, item):
	start = 0
	end = len(array) - 1

	while start <= end:
		mid = (end + start) // 2

		if array[mid] == item:
			return mid

		# Because the array is sorted
		if item < array[mid]:
			# Assign new right bound and continue the loop
			end = mid - 1
		elif item > array[mid]:
			# Assign new left bound and continue the loop
			start = mid + 1

	return -1


# Run
array = generate_input()
array.sort() # Provide sorted array
print(" - Data: ")
print(array)

index = search(array, 0, len(array) - 1, 7)
print(" - Search (7). Index: " + str(index))

index = search(array, 0, len(array) - 1, 11)
print(" - Search (11) non-recursive. Index: " + str(index))