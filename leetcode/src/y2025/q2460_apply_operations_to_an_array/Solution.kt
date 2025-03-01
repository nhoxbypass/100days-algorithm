package y2025.q2460_apply_operations_to_an_array

class Solution {
    /**
     * - Time complexity: O(N)
     * - Space complexity: O(N)
     */
    fun applyOperations(nums: IntArray): IntArray {
        val n = nums.size
        val result = IntArray(n)

        var i = 0
        var idx = 0
        while (i < n) {
            if (nums[i] == 0) {
                i++
                continue
            }
            if (i != n - 1 && nums[i] == nums[i + 1]) {
                result[idx] = nums[i] * 2
                i++
            } else {
                result[idx] = nums[i]
            }
            idx++
            i++
        }

        return result
    }
}

fun main() {
    val res = Solution().applyOperations(
        intArrayOf(1, 2, 2, 1, 1, 0)
    )
    println(res)
}