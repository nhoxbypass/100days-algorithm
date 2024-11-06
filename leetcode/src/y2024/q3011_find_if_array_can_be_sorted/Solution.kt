package y2024.q3011_find_if_array_can_be_sorted

class Solution {
    /**
     * - Time complexity: O(N)
     * - Space complexity: O(1)
     */
    fun canSortArray(nums: IntArray): Boolean {
        val n = nums.size

        // bubble-sort with special "set bits" condition before swapping
        for (i in 0..n - 2) {
            var swapped = false
            for (j in 0..n - i - 2) {
                if (nums[j] > nums[j + 1] && hasSameSetBits(nums[j], nums[j + 1])) {
                    // swap the bigger number toward the end
                    nums[j] = nums[j + 1].also { nums[j + 1] = nums[j] }
                    swapped = true
                }
            }
            if (!swapped)
                break
        }

        // because the special "set bits" condition, the array MAY NOT be sorted
        // -> check whether the array is sorted
        for (i in 0..n - 2) {
            if (nums[i] > nums[i + 1]) {
                return false
            }
        }
        return true
    }

    private fun hasSameSetBits(a: Int, b: Int): Boolean {
        return a.countOneBits() == b.countOneBits()
    }
}

fun main() {
    val result = Solution().canSortArray(
        intArrayOf(8, 4, 2, 30, 15)
    )
    println(result)
}