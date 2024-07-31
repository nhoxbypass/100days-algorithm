package y2024.q1653_minimum_deletions_to_make_string_balanced

import kotlin.math.min

class Solution {
    /**
     * - Time complexity: O(N^2)
     * - Space complexity: O(1)
     */
    fun minimumDeletions(s: String): Int {
        var countA = 0
        var countB = 0
        var minDeletions = 0

        // Traverse the string
        for (c in s) {
            if (c == 'a') {
                // char is 'a'
                // delete this 'a' OR keep it and count the deletions
                minDeletions = minOf(minDeletions + 1, countB)
            } else {
                // char is 'b'
                // just count it
                countB++
            }
        }

        return minDeletions
    }
}

fun main() {
    val res = Solution().minimumDeletions(
       "aabaaabbab"
    )
    println(res)
}