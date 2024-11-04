package y2024.q3163_string_compression_iii

class Solution {
    /**
     * - Time complexity: O(N)
     * - Space complexity: O(1)
     */
    fun compressedString(word: String): String {
        // init a string builder `comp` to store compressed string
        val comp = StringBuilder()

        // loop through the chars of input word to calculate the count
        var i = 0
        while (i < word.length) {
            val currChar = word[i]
            var j = i + 1
            var freq = 1
            while (j < word.length && currChar == word[j]) {
                freq++
                j++
                if (freq == 9) break
            }
            // append the current char and its frequency
            comp.append(freq).append(currChar)
            // these chars from `i` to `j - 1` are compressed
            // move to `j` index to continue the loop
            i = j
        }

        return comp.toString()
    }
}

fun main() {
    val result = Solution().compressedString(
        "ft"
    )
    println(result)
}