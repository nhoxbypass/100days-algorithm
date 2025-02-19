package y2025.q2375_construct_smallest_number_from_di_string

import java.util.LinkedHashSet

class Solution {
    /**
     * - Time complexity: O(N)
     * - Space complexity: O(N)
     */
    fun smallestNumber(pattern: String): String {
        val n = pattern.length
        val num = LinkedHashSet<Int>()

        var nextDigit = 1
        // loop through pattern list
        var i = 0
        while (i < n) {
            val nextPattern = pattern[i]
            if (nextPattern == 'I') {
                // add curr digit to `num`
                num.add(nextDigit)
                // move to next: next pattern is 'I'
                nextDigit++
                i++
            } else {
                // next pattern is 'D'
                // -> count the number of consecutive 'D' pattern
                val dCount = countConsecutiveD(pattern, i)
                // -> add curr digit AND (dCount) digits to `num`
                for (j in dCount downTo 0) {
                    num.add(nextDigit + j)
                }
                // move through ALL 'D' patterns
                nextDigit += dCount
                i += dCount
                // move to next: next pattern is 'I' (because we count all 'D' streak)
                nextDigit++
                i++
            }
        }

        if (i == n) {
            num.add(nextDigit)
        }

        return num.joinToString("")
    }

    private fun countConsecutiveD(pattern: String, start: Int): Int {
        var endExclusive = start
        while (endExclusive < pattern.length && pattern[endExclusive] == 'D') {
            endExclusive++
        }
        return endExclusive - start
    }
}

fun main() {
    val res = Solution().smallestNumber(
        "IIIDIDDD"
    )
    println(res)
}