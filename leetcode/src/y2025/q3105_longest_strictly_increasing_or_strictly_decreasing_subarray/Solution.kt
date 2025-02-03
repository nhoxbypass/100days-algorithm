package y2025.q3105_longest_strictly_increasing_or_strictly_decreasing_subarray

class Solution {
    /**
     * - Time complexity: O(N)
     * - Space complexity: O(1)
     */
    fun longestMonotonicSubarray(nums: IntArray): Int {
        var maxLength = 1
        var incLength = 1
        var decLength = 1

        for (i in 0 until nums.size - 1) {
            if (nums[i + 1] > nums[i]) {
                // increasing sequence
                incLength++
                // reset decLength
                decLength = 1
            } else if (nums[i + 1] < nums[i]) {
                // decreasing sequence
                decLength++
                // reset incLength
                incLength = 1
            } else {
                incLength = 1
                decLength = 1
            }
            maxLength = maxOf(maxLength, maxOf(incLength, decLength))
        }
        return maxLength
    }
}

fun main() {
    val res = Solution().longestMonotonicSubarray(
        intArrayOf(1, 3, 2, 4)
    )
    println(res)
}