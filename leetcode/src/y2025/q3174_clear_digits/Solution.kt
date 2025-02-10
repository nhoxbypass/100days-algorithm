package y2025.q3174_clear_digits

class Solution {
    /**
     * - Time complexity: O(N)
     * - Space complexity: O(1)
     */
    fun clearDigits(s: String): String {
        val chars = s.toCharArray()

        var currPointerIdx = 0
        for (c in chars) {
            if (c.isDigit()) {
                chars[--currPointerIdx] = ' '
            } else {
                chars[currPointerIdx++] = c
            }
        }

        // return new String from `chars` with offset [0, currPointerIdx]
        return String(chars, 0, currPointerIdx)
    }
}

fun main() {
    val res = Solution().clearDigits(
        "abc"
    )
    println(res)
}