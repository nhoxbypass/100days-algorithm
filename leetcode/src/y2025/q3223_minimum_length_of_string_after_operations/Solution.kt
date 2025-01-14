package y2025.q3223_minimum_length_of_string_after_operations

class Solution {
    /**
     * - Time complexity: O(N)
     * - Space complexity: O(1)
     */
    fun minimumLength(s: String): Int {
        val charFreq = IntArray(26)
        s.forEach { c ->
            charFreq[c - 'a']++
        }

        var ans = 0
        for (count in charFreq) {
            if (count > 0) {
                ans += if (count % 2 == 0) 2 else 1
            }
        }
        return ans
    }
}

fun main() {
    val res = Solution().minimumLength(
        "annabelle",
    )
    println(res)
}