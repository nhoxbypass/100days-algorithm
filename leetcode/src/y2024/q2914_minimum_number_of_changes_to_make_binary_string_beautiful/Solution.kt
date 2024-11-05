package y2024.q2914_minimum_number_of_changes_to_make_binary_string_beautiful

class Solution {
    /**
     * - Time complexity: O(N)
     * - Space complexity: O(1)
     */
    fun minChanges(s: String): Int {
        var changeCount = 0
        var i = 0
        while (i < s.length - 1) {
            if (s[i] != s[i + 1]) {
                changeCount++
            }
            i += 2
        }
        return changeCount
    }
}

fun main() {
    val result = Solution().minChanges(
        "1001"
    )
    println(result)
}