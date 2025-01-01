package y2024.q1422_maximum_score_after_splitting_a_string

class Solution {
    /**
     * - Time complexity: O(N)
     * - Space complexity: O(N)
     */
    fun maxScore(s: String): Int {
        var res = 0
        val len = s.length

        val zeros = IntArray(len)
        var cZeros = 0
        for (i in 0..<len) {
            if (s[i] == '0') {
                cZeros++
            }
            zeros[i] = cZeros
        }

        val ones = IntArray(len)
        var cOnes = 0
        for (i in len - 1 downTo 0) {
            ones[i] = cOnes
            if (s[i] == '1') {
                cOnes++
            }
        }

        for (i in 0..<len - 1) {
            val temp = zeros[i] + ones[i]
            if (res < temp) {
                res = temp
            }
        }

        return res
    }
}

fun main() {
    val res = Solution().maxScore("011101")
    println(res)
}