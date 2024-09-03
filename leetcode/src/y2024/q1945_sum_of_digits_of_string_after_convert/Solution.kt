package y2024.q1945_sum_of_digits_of_string_after_convert

class Solution {
    /**
     * - Time complexity: O(N)
     * - Space complexity: O(N)
     */
    fun getLucky(s: String, k: Int): Int {
        // convert input text to digits
        var digits = convertTextToDigits(s)

        // loop K times to calculate sum of digits
        var times = 0
        while (times < k) {
            var sum = 0
            digits.forEach { digit ->
                sum += digit.digitToInt()
            }
            digits = sum.toString()
            times++
        }
        return digits.toInt()
    }

    private fun convertTextToDigits(text: String): String {
        var digits = ""
        text.forEach { c ->
            val digit = c - 'a' + 1
            digits += digit
        }
        return digits
    }
}

fun main() {
    val res = Solution().getLucky("iiii", 2)
    println(res)
}