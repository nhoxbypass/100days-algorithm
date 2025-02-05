package y2025.q1790_check_if_one_string_swap_can_make_strings_equal

class Solution {
    /**
     * - Time complexity: O(N)
     * - Space complexity: O(1)
     */
    fun areAlmostEqual(s1: String, s2: String): Boolean {
        val n = s1.length
        var diffIdx = -1
        for (i in 0..<n) {
            if (s1[i] != s2[i]) {
                if (diffIdx == Int.MIN_VALUE) {
                    // already swapped
                    return false
                } else if (diffIdx == -1) {
                    // not swap yet
                    diffIdx = i
                } else {
                    // found the diff idx before
                    if (s1[i] != s2[diffIdx] || s2[i] != s1[diffIdx]) {
                        // but the character is different
                        return false
                    } else {
                        // mark swapped
                        diffIdx = Int.MIN_VALUE
                    }
                }
            }
        }
        return diffIdx == -1 || diffIdx == Int.MIN_VALUE
    }
}

fun main() {
    val res = Solution().areAlmostEqual(
        "npv", "zpn"
    )
    println(res)
}