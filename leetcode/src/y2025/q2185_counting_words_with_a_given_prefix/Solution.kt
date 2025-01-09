package y2025.q2185_counting_words_with_a_given_prefix

class Solution {
    /**
     * - Time complexity: O(N * M)
     * - Space complexity: O(1)
     */
    fun prefixCount(words: Array<String>, pref: String): Int {
        val prefLen = pref.length
        var count = 0
        words.forEach { w ->
            if (w.length >= prefLen && w.startsWith(pref)) {
                count++
            }
        }
        return count
    }
}

fun main() {
    val res = Solution().prefixCount(
        arrayOf("pay", "attention", "practice", "attend"),
        "at"
    )
    println(res)
}