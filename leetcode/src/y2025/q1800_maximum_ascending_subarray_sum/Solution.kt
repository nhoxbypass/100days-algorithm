package y2025.q1800_maximum_ascending_subarray_sum

class Solution {
    /**
     * - Time complexity: O(N)
     * - Space complexity: O(1)
     */
    fun maxAscendingSum(nums: IntArray): Int {
        // max sum
        var maxSum = 0
        // current contiguous sub-array sum
        var currSum = nums[0]
        for (i in 1 until nums.size) {
            if (nums[i - 1] < nums[i]) {
                // ascending
                // -> increase the curr sum
                currSum += nums[i]
            } else {
                // not ascending
                // -> calculate max sum
                maxSum = maxOf(maxSum, currSum)
                // -> reset the sum
                currSum = nums[i]
            }
        }

        return maxOf(maxSum, currSum)
    }

    fun maxAscendingSumOld(nums: IntArray): Int {
        val n = nums.size
        var maxSum = nums[0]
        for (i in 0..<n - 1) {
            var sum = nums[i]
            for (j in (i + 1)..<n) {
                if (nums[j - 1] < nums[j]) {
                    sum += nums[j]
                } else {
                    break
                }
            }
            if (sum > maxSum) {
                maxSum = sum
            }
        }
        return maxSum
    }
}

fun main() {
    val res = Solution().maxAscendingSum(
        intArrayOf(10, 20, 30, 5, 10, 50)
    )
    println(res)
}