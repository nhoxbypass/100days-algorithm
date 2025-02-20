package y2025.q1980_find_unique_binary_string

class Solution {
    /**
     * - Time complexity: O(N)
     * - Space complexity: O(1)
     */
    fun findDifferentBinaryString(nums: Array<String>): String {
        val result = StringBuilder()
        for (i in nums.indices) {
            if (nums[i][i] == '0') {
                result.append('1')
            } else {
                result.append('0')
            }
        }
        return result.toString()
    }
}

fun main() {
    val res = Solution().findDifferentBinaryString(
        arrayOf("01", "10")
    )
    println(res)
}