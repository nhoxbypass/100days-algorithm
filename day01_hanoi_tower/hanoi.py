#Arrays store disks
A = [5, 4, 3, 2, 1]
B = []
C = []

# Move @numberOfFloor disks from @currPeg to @targetPeg
def hanoi_move(numberOfFloor, currPeg, tempPeg, targetPeg):
	# Number of Floor also the size of current peg
	if numberOfFloor > 0:
		# current Peg is not empty, move n-1 disk above from current Peg to temporary peg
		# To make way for moving the biggest disk, left it alone in current Peg
		hanoi_move(numberOfFloor - 1, currPeg, targetPeg, tempPeg)
		
		# Bring the biggest disk (nth disk) to the target peg
		disk = currPeg.pop()
		targetPeg.append(disk)
		print('### Moving disk ' + str(disk) + ' ###')
		print(A, B, C, sep='\n')
		print('\n')

		# Move n-1 disks that we left on temporary peg to target peg
		hanoi_move(numberOfFloor - 1, tempPeg, currPeg, targetPeg)



# @Test
hanoi_move(len(A),A, B, C)