package y2024.q2501_longest_square_streak_in_an_array

import kotlin.math.pow

class Solution {
    /**
     * - Time complexity: O(N * 5)
     * - Space complexity: O(N)
     */
    fun longestSquareStreak(nums: IntArray): Int {
        // Store the elements of nums in a set to quickly check if it exists
        val numSet = nums.toSet()

        // Loop through each number to find their square streak and check max streak length
        var maxLen = -1
        for (currNum in nums) {
            var len = 1
            var pow = 2
            // With the constraints (10^5) -> The length of the longest square streak possible is 5
            // We only loop from 1 -> 5 to find the square streak
            for (j in 1..5) {
                val targetNum = currNum.toDouble().pow(pow).toInt()
                if (numSet.contains(targetNum)) {
                    len++
                    pow *= 2
                } else {
                    break
                }
            }
            if (len != 1 && len > maxLen) {
                maxLen = len
            }
            if (maxLen == 5) {
                break
            }
        }

        return maxLen
    }

    fun longestSquareStreakOld(nums: IntArray): Int {
        // sort the input numbers
        nums.sort()

        var maxLen = -1
        val size = nums.size
        for (i in 0..size - 2) {
            val currNum = nums[i]
            var len = 1
            var pow = 2
            for (j in i + 1..<size) {
                if (nums[j] == currNum.toDouble().pow(pow).toInt()) {
                    len++
                    pow *= 2
                }
            }
            if (len != 1 && len > maxLen) {
                maxLen = len
            }
            if (maxLen == 5) {
                break
            }
        }

        return maxLen
    }
}

fun main() {
    val result = Solution().longestSquareStreak(
        intArrayOf(4, 3, 6, 16, 8, 2)
    )
    println(result)
}