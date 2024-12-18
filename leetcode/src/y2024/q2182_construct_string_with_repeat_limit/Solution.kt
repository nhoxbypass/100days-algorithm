package y2024.q2182_construct_string_with_repeat_limit

class Solution {
    /**
     * - Time complexity: O(NLogN+KLogN)
     * - Space complexity: O(N)
     */
    fun repeatLimitedString(s: String, repeatLimit: Int): String {
        // count the frequency of each char in string `s`
        val freqCount = IntArray(26)
        for (c in s) {
            freqCount[c - 'a']++
        }

        val sb = StringBuilder()
        var right = 25
        var left = 24

        while (right >= 0) {
            while (left >= 0 && freqCount[left] == 0) {
                left--
            }

            if (freqCount[right] > repeatLimit) {
                sb.append(CharArray(repeatLimit) { 'a' + right })
                freqCount[right] -= repeatLimit
                if (left < 0) {
                    break
                }
                sb.append('a' + left)
                freqCount[left]--
            } else {
                sb.append(CharArray(freqCount[right]) { 'a' + right })
                right = left
                left--
            }
        }

        return sb.toString()
    }
}

fun main() {
    val result = Solution().repeatLimitedString(
        "cczazcc",
        3
    )
    println(result)
}