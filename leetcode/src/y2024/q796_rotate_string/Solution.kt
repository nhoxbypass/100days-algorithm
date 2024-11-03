package y2024.q796_rotate_string

class Solution {
    /**
     * - Time complexity: O(N)
     * - Space complexity: O(N)
     */
    fun rotateString(s: String, goal: String): Boolean {
        if (s.length != goal.length) return false

        val doubleS = s + s
        return doubleS.contains(goal)
    }
}

fun main() {
    val result = Solution().rotateString(
        "abcde",
        "cdeab"
    )
    println(result)
}