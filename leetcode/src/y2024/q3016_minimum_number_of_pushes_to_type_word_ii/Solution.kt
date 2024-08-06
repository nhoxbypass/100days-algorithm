package y2024.q3016_minimum_number_of_pushes_to_type_word_ii

class Solution {
    /**
     * - Time complexity: O(NLogN)
     * - Space complexity: O(1)
     */
    fun minimumPushes(word: String): Int {
        if (word.length <= 8)
            return word.length

        // count frequency of each char in given [word]
        val freqCount = IntArray(26) { 0 }
        word.forEach { c ->
            freqCount[c - 'a']++
        }

        // sort the freq count list
        freqCount.sortDescending()

        // loop through the freq count list to count the total number of pushes
        var totalPushCount = 0
        freqCount.forEachIndexed { index, count ->
            // calculate the number of push times that cost for the current char
            // Ex:
            // - First 8 chars -> cost 1 push / char
            // - Second 8 chars -> cost 2 pushes / char
            val pushPerChar = index / 8 + 1
            // sum the total number of pushes
            totalPushCount += (pushPerChar * count)
        }

        return totalPushCount
    }
}

fun main() {
    val res = Solution().minimumPushes(
        "aabbccddeeffgghhiiiiii"
    )
    println(res)
}