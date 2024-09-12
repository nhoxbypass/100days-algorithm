package y2024.q1684_count_the_number_of_consistent_strings

class Solution {
    /**
     * - Time complexity: O(N * M)
     * - Space complexity: O(N + M)
     */
    fun countConsistentStrings(allowed: String, words: Array<String>): Int {
        // build set of allowed chars
        val allowedChars = HashSet<Char>()
        allowed.forEach { c ->
            allowedChars.add(c)
        }

        // loop through given words to check each char
        var validCount = 0
        words.forEach { word ->
            var valid = true
            for (c in word) {
                if (!allowedChars.contains(c)) {
                    valid = false
                    break
                }
            }
            if (valid) {
                validCount++
            }
        }
        return validCount
    }
}

fun main() {
    val res = Solution().countConsistentStrings(
        "ab",
        arrayOf("ad", "bd", "aaab", "baa", "badab")
    )
    println(res)
}