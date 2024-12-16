package y2024.q3264_final_array_state_after_k_multiplication_operations_i

import java.util.*

class Solution {
    /**
     * - Time complexity: O(NLogN+KLogN)
     * - Space complexity: O(N)
     */
    fun getFinalState(nums: IntArray, k: Int, multiplier: Int): IntArray {
        // init a PQ to compare the input `nums` array
        // based on its value and its index (ASC) (the first item will have MIN value and MIN index)
        val pq = PriorityQueue(object : Comparator<Int> {
            override fun compare(idx1: Int, idx2: Int): Int {
                val compareResult = nums[idx1].compareTo(nums[idx2])
                return if (compareResult == 0) {
                    // compare the index
                    // to keep the original order
                    idx1.compareTo(idx2)
                } else {
                    compareResult
                }
            }
        })

        // fill the data into PQ
        pq.addAll(nums.indices)

        // repeat K operations
        repeat(k) {
            // remove the first item (item has MIN value and MIN index)
            val idx = pq.remove()
            // multiply
            nums[idx] *= multiplier
            // put back to the original PQ
            pq.add(idx)
        }

        return nums
    }
}

fun main() {
    val result = Solution().getFinalState(
        intArrayOf(2, 1, 3, 5, 6),
        5,
        2
    )
    println(result)
}