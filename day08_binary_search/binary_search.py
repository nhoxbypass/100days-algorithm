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


def interpolation_search(array, low, high, item):
	# Since array is sorted, an element present in array must be in range defined by corner
	if low > high or item < array[low] or item > array[high]:
		return - 1
	
	# If only 1 item left, compare this item
	if low == high:
		if array[low] == item:
			return low
		return -1
	
	# Probing the position with keeping uniform distribution in mind.
	mid = low + int(float(high - low) * (item - array[low]) / (array[high] - array[low]))
	
	# Condition of target found
	if array[mid] == item:
		return mid

	if item < array[mid]:
		# If item is smaller, item is in lower part
		return interpolation_search(array, low, mid - 1, item)
	elif item > array[mid]:
		# If item is larger, item is in upper part
		return interpolation_search(array, mid + 1, high, item)


# Run
array = generate_input()
array.sort() # Provide sorted array
print(" - Data: ")
print(array)

index = search(array, 0, len(array) - 1, 7)
print(" - Search (7). Index: " + str(index))

index = search_no_recursive(array, 11)
print(" - Search (11) non-recursive. Index: " + str(index))

index = interpolation_search(array, 0, len(array) - 1, 15)
print(" - Search (15) interpolation search. Index: " + str(index))