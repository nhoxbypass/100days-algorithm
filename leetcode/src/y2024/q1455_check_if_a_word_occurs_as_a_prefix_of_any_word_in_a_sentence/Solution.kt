package y2024.q1455_check_if_a_word_occurs_as_a_prefix_of_any_word_in_a_sentence

class Solution {
    /**
     * - Time complexity: O(N * K)
     * - Space complexity: O(N)
     */
    fun isPrefixOfWord(sentence: String, searchWord: String): Int {
        val wordLen = searchWord.length
        var charPos = 0
        var wordPos = 1
        var currWordValid = true
        for (c in sentence) {
            if (c == ' ') {
                // start new word
                wordPos++
                charPos = 0
                // mark curr word VALID
                currWordValid = true
            } else {
                if (!currWordValid)
                    continue

                if (c == searchWord[charPos]) {
                    if (charPos == wordLen - 1) {
                        return wordPos
                    } else if (charPos < wordLen - 1) {
                        charPos++
                    } else {
                        // mark curr word INVALID
                        currWordValid = false
                    }
                } else {
                    // not match
                    // mark curr word INVALID
                    currWordValid = false
                }
            }
        }
        return -1
    }

    fun isPrefixOfWordOld(sentence: String, searchWord: String): Int {
        val words = sentence.split(" ")

        for (i in words.indices) {
            if (words[i].startsWith(searchWord)) {
                return i + 1
            }
        }

        return -1
    }
}

fun main() {
    val result = Solution().isPrefixOfWord(
        "i love eating burger",
        "burg"
    )
    println(result)
}