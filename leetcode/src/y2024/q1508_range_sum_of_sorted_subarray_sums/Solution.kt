package y2024.q1508_range_sum_of_sorted_subarray_sums

class Solution {
    private val MOD = 1000000007

    /**
     * - Time complexity: O(N^2)
     * - Space complexity: O(N)
     */
    fun rangeSum(nums: IntArray, n: Int, left: Int, right: Int): Int {
        // calculate list of sums
        val sumList = mutableListOf<Int>()
        for (i in 0..<n) {
            // count the start number as a sub-array
            sumList.add(nums[i])
            // count sum for sub-array start with index [i]
            var sum = nums[i]
            for (j in i + 1..<n) {
                sum = (sum + nums[j]) % MOD
                if (sum > 0) {
                    sumList.add(sum)
                }
            }
        }

        // sort the list of sums
        sumList.sort()

        // calculate total sum from left -> right
        var totalSum = 0
        for (i in (left - 1)..<right) {
            totalSum = (totalSum + sumList[i]) % MOD
        }

        return totalSum
    }
}

fun main() {
    val res = Solution().rangeSum(
        intArrayOf(9, 3, 2, 2, 6, 9, 6, 6),
        8,
        4,
        8
    )
    println(res)
}