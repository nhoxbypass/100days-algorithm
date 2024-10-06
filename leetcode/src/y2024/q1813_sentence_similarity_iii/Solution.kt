package y2024.q1813_sentence_similarity_iii

/**
 * - Time complexity: O(N)
 * - Space complexity: O(N)
 */
class Solution {
    fun areSentencesSimilar(sentence1: String, sentence2: String): Boolean {
        // split S1, S2 into words array
        // lWords: long, sWords: short
        val (lWords, sWords) = if (sentence1.length >= sentence2.length) {
            Pair(sentence1.split(" "), sentence2.split(" "))
        } else {
            Pair(sentence2.split(" "), sentence1.split(" "))
        }

        // loop from start of lWords, match with sWords
        // -> find the first different -> startIdx
        var startIdx = 0
        for (i in lWords.indices) {
            if (i >= sWords.size) return true
            if (lWords[i] == sWords[startIdx]) {
                startIdx++
                continue
            } else {
                break
            }
        }

        // loop from end of lWords, match with sWords
        // -> find the last different -> endIdx
        var endIdx = sWords.size - 1
        for (i in lWords.size - 1 downTo 0) {
            if (endIdx < 0) return true
            if (lWords[i] == sWords[endIdx]) {
                endIdx--
                continue
            } else {
                break
            }
        }

        return startIdx > endIdx
    }
}

fun main() {
    val result = Solution().areSentencesSimilar(
        "of",
        "A lot of words"
    )
    println(result)
}