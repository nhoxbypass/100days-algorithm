package y2024.q962_maximum_width_ramp

class Solution {
    /**
     * - Time complexity: O(N)
     * - Space complexity: O(N)
     */
    fun maxWidthRamp(nums: IntArray): Int {
        // stack contains index of number from large -> small
        // the index of SMALLEST number will be on TOP
        val smallIdxStack = mutableListOf<Int>()
        // loop from the beginning of input number array to build the stack
        for (i in nums.indices) {
            if (smallIdxStack.isEmpty()) {
                smallIdxStack.add(i)
                continue
            }
            val currSmallestNum = nums[smallIdxStack.last()]
            if (nums[i] < currSmallestNum) {
                smallIdxStack.add(i)
            }
        }

        // loop from the ending of input number array to match RAMP condition
        var maxWidth = -1
        for (j in (nums.size - 1) downTo 0) {
            while (true) {
                if (smallIdxStack.isEmpty()) break
                val currSmallestNum = nums[smallIdxStack.last()]
                if (currSmallestNum <= nums[j]) {
                    // match RAMP condition
                    // take this number -> remove this index
                    // calculate width and compare with current max width
                    val width = j - smallIdxStack.removeLast()
                    if (width > maxWidth) {
                        maxWidth = width
                    }
                } else {
                    break
                }
            }
        }

        return maxWidth
    }

    /**
     * - Time complexity: O(N^2)
     * - Space complexity: O(N)
     */
    fun maxWidthRampOld(nums: IntArray): Int {
        var maxWidth = -1
        for (i in 0..nums.size - 2) {
            for (j in (nums.size - 1) downTo (i + 1)) {
                if (nums[i] <= nums[j]) {
                    val width = j - i
                    if (width > maxWidth) {
                        maxWidth = width
                    }
                    break
                }
            }
        }
        return maxWidth
    }
}

fun main() {
    val result = Solution().maxWidthRamp(
        intArrayOf(
            6, 0, 8, 2, 1, 5
        )
    )
    println(result)
}