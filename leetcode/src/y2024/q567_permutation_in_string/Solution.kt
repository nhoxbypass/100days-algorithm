package y2024.q567_permutation_in_string

/**
 * - Time complexity: O((N−M)M)
 * - Space complexity: O(1)
 */
class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        // count chars frequencies of S1
        val freqCount = IntArray(26) { 0 }
        var idx: Int
        s1.forEach { c ->
            idx = c - 'a'
            freqCount[idx] = freqCount[idx] + 1
        }

        val s1Len = s1.length
        val n = s2.length - s1Len
        for (i in 0..n) {
            // count chars frequencies of sub-string of S2
            val subFreqCount = IntArray(26) { 0 }
            for (j in i..<i + s1Len) {
                idx = s2[j] - 'a'
                subFreqCount[idx] = subFreqCount[idx] + 1
            }
            // compare freq
            if (freqCount.contentEquals(subFreqCount)) {
                return true
            }
        }

        return false
    }

    fun checkInclusionOld(s1: String, s2: String): Boolean {
        // sort S1 string
        val sortedS1 = s1.toCharArray().sorted().joinToString("")
        val s1Len = s1.length

        for (i in 0..(s2.length - s1Len)) {
            // sort sub string of S2
            val subS2 = s2.substring(i, i + s1Len).toCharArray().sorted().joinToString("")
            // compare with sorted S1
            if (sortedS1 == subS2) {
                return true
            }
        }

        return false
    }
}

fun main() {
    val result = Solution().checkInclusion(
        "ab",
        "eidbaooo"
    )
    println(result)
}