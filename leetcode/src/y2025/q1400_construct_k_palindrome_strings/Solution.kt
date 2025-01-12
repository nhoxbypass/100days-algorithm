package y2025.q1400_construct_k_palindrome_strings

class Solution {
    /**
     * - Time complexity: O(N)
     * - Space complexity: O(1)
     */
    fun canConstruct(s: String, k: Int): Boolean {
        // calculate char freq for `s`
        val charFreq = HashMap<Char, Int>()
        s.forEach { c ->
            charFreq[c] = charFreq.getOrDefault(c, 0) + 1
        }

        // count all char with odd freq
        val oddFreqCount = charFreq.count {
            it.value % 2 == 1
        }

        return k in oddFreqCount..s.length
    }
}

fun main() {
    val res = Solution().canConstruct(
        "annabelle",
        2
    )
    println(res)
}