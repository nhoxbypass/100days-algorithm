package y2025.q3042_count_prefix_and_suffix_pairs_i

class Solution {
    /**
     * - Time complexity: O(N^2)
     * - Space complexity: O(1)
     */
    fun countPrefixSuffixPairs(words: Array<String>): Int {
        var pairCount = 0
        val n = words.size
        for (i in 0..n - 2) {
            for (j in i + 1..n - 1) {
                if (isPrefixAndSuffix(words[i], words[j])) {
                    pairCount++
                }
            }
        }
        return pairCount
    }

    private fun isPrefixAndSuffix(str1: String, str2: String): Boolean {
        return str2.startsWith(str1) && str2.endsWith(str1)
    }
}

fun main() {
    val res = Solution().countPrefixSuffixPairs(
        arrayOf("a", "aba", "ababa", "aa")
    )
    println(res)
}