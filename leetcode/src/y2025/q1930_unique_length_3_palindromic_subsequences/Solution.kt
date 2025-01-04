package y2025.q1930_unique_length_3_palindromic_subsequences

class Solution {
    /**
     * - Time complexity: O(N + Q)
     * - Space complexity: O(N)
     */
    fun countPalindromicSubsequence(s: String): Int {
        var count = 0

        // loop through the alphabet
        for (i in 'a'..'z') {
            // find the first occurrence of the letter
            val left = s.indexOf(i)
            // find the last occurrence of the letter
            val right = s.lastIndexOf(i)

            // if both of them exist and right position > left position
            if (left != -1 && right != -1 && right > left) {
                // substring between left and right positions
                val subStr = s.substring(left + 1, right)
                // convert to Set<> to count unique chars
                val uniqueChars = subStr.toSet()
                count += uniqueChars.size
            }
        }

        return count
    }
}

fun main() {
    val res = Solution().countPalindromicSubsequence(
        "aabca"
    )
    println(res)
}