package y2025.q916_word_subsets

class Solution {
    /**
     * - Time complexity: O(N)
     * - Space complexity: O(1)
     */
    fun wordSubsets(words1: Array<String>, words2: Array<String>): List<String> {
        // calculate max char freq for `words2`
        val maxCharFreqW2 = countMaxCharFreq(words2)

        val universalWords = ArrayList<String>()
        // loop through `words1`
        for (w in words1) {
            // calculate char freq for each word `w`
            val currCharFreq = countCharFreq(w)
            // compare with max char freq of `words2`
            // to consider universal
            if (isUniversal(currCharFreq, maxCharFreqW2)) {
                universalWords.add(w)
            }
        }
        return universalWords
    }

    private fun countMaxCharFreq(words: Array<String>): ByteArray {
        val maxFreq = ByteArray(26)
        for (w in words) {
            val currFreq = ByteArray(26)
            for (c in w) {
                val cIdx = c - 'a'
                currFreq[cIdx]++
                if (currFreq[cIdx] > maxFreq[cIdx]) {
                    maxFreq[cIdx] = currFreq[cIdx]
                }
            }
        }
        return maxFreq
    }

    private fun countCharFreq(word: String): ByteArray {
        val freq = ByteArray(26)
        for (c in word) {
            freq[c - 'a']++
        }
        return freq
    }

    private fun isUniversal(charFreq: ByteArray, maxCharFreq: ByteArray): Boolean {
        for (i in 0..<26) {
            if (charFreq[i] < maxCharFreq[i]) {
                return false
            }
        }
        return true
    }
}

fun main() {
    val res = Solution().wordSubsets(
        arrayOf("amazon", "apple", "facebook", "google", "leetcode"),
        arrayOf("e", "o")
    )
    println(res)
}