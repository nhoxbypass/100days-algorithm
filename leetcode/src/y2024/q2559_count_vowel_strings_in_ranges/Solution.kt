package y2024.q2559_count_vowel_strings_in_ranges

class Solution {
    /**
     * - Time complexity: O(N + Q)
     * - Space complexity: O(N)
     */
    fun vowelStrings(words: Array<String>, queries: Array<IntArray>): IntArray {
        // prepare an array to store prefix sums (cumulative count) of vowel strings
        val cachedVowelSum = IntArray(words.size + 1)

        // store result for each query
        val ans = IntArray(queries.size)

        // build the prefix sum array for vowel strings
        for (i in words.indices) {
            val prevSum = cachedVowelSum[i]
            cachedVowelSum[i + 1] = prevSum + if (isValidWord(words[i])) 1 else 0
        }

        // process each query
        for (idx in queries.indices) {
            // get the range for the current query
            val (start, end) = queries[idx]
            // calculate the count of vowel strings in the range [start, end]
            ans[idx] = cachedVowelSum[end + 1] - cachedVowelSum[start]
        }

        return ans
    }

    fun vowelStringsOld(words: Array<String>, queries: Array<IntArray>): IntArray {
        val cachedWords = HashMap<Int, Boolean>()
        val ans = IntArray(queries.size)
        queries.forEachIndexed { idx, q ->
            var count = 0
            for (wordIdx in q[0]..q[1]) {
                val isValid = cachedWords.get(wordIdx) ?: isValidWord(words[wordIdx]).also {
                    cachedWords.put(wordIdx, it)
                }
                if (isValid) {
                    count++
                }
            }
            ans[idx] = count
        }
        return ans
    }

    private val vowels = arrayOf('a', 'e', 'i', 'o', 'u')

    private fun isValidWord(w: String): Boolean {
        return vowels.contains(w.first()) && vowels.contains(w.last())
    }
}

fun main() {
    val res = Solution().vowelStrings(
        arrayOf("aba", "bcb", "ece", "aa", "e"),
        arrayOf(
            intArrayOf(0, 2),
            intArrayOf(1, 4),
            intArrayOf(1, 1)
        )
    )
    println(res)
}