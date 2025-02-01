package y2025.q3151_special_array_i

class Solution {
    /**
     * - Time complexity: O(N)
     * - Space complexity: O(1)
     */
    fun isArraySpecial(nums: IntArray): Boolean {
        return nums.indices.all { idx ->
            nums[0] % 2 == (nums[idx] % 2 + idx % 2) % 2
        }
    }
}

fun main() {
    val res = Solution().isArraySpecial(
        intArrayOf(1, 3, 2, 4)
    )
    println(res)
}