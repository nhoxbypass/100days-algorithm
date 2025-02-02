package y2025.q1752_check_if_array_is_sorted_and_rotated

class Solution {
    /**
     * - Time complexity: O(N)
     * - Space complexity: O(1)
     */
    fun check(nums: IntArray): Boolean {
        val n = nums.size

        // If the array has 1 or 2 elements, it is always considered valid
        if (n < 3) {
            return true
        }

        var idx = 1
        // Find the first violation of non-decreasing order
        while (idx < n && nums[idx] >= nums[idx - 1]) {
            idx++
        }
        // Continue checking, ensuring that the remaining sequence is non-decreasing
        // considering circular indexing with (i + 1) % n
        while (idx < n && nums[idx] <= nums[(idx + 1) % n]) {
            idx++
        }

        // If we successfully iterated through the entire array, it means
        // there is at most one rotation point, and the array is valid
        return idx == n
    }
}

fun main() {
    val res = Solution().check(
        intArrayOf(1, 3, 2, 4)
    )
    println(res)
}