package y2024.q884_uncommon_words_from_two_sentences

class Solution {
    /**
     * - Time complexity: O(N + M)
     * - Space complexity: O(N + M)
     */
    fun uncommonFromSentences(s1: String, s2: String): Array<String> {
        // count word frequency
        val freqMap = HashMap<String, Int>()
        val mergedString = "$s1 $s2"
        mergedString.split(' ').forEach { word ->
            freqMap[word] = freqMap.getOrDefault(word, 0) + 1
        }

        // find uncommon words
        val resultList = ArrayList<String>()
        freqMap.forEach { (word, freq) ->
            if (freq == 1) {
                // appears exactly once in both sentence
                resultList.add(word)
            }
        }

        return resultList.toTypedArray()
    }
}

fun main() {
    val res = Solution().uncommonFromSentences(
        "this apple is sweet",
        "this apple is sour"
    )
    println(res)
}