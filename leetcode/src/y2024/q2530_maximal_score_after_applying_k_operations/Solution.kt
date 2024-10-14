package y2024.q2530_maximal_score_after_applying_k_operations

import java.util.PriorityQueue
import kotlin.math.ceil

class Solution {
    /**
     * - Time complexity: O(NLogN)
     * - Space complexity: O(N)
     */
    fun maxKelements(nums: IntArray, k: Int): Long {
        // init PQ to store sorted nums
        // sort by REVERSED natural order (DESC)
        // because: access first() took O(1), but last() took O(N)
        val sortedNums = PriorityQueue<Int>(nums.size, compareByDescending { it })
        nums.forEach { sortedNums.add(it) }

        var count = 0
        var score = 0L
        while (count < k) {
            // poll the first num (max num)
            val maxNum = sortedNums.poll() ?: break
            // increase score
            score += maxNum
            // add the updated num to PQ
            sortedNums.add(ceil(maxNum / 3.0).toInt())
            // increase op count
            count++
        }

        return score
    }
}

fun main() {
    val result = Solution().maxKelements(
        intArrayOf(756902131, 995414896, 95906472, 149914376, 387433380, 848985151),
        6
    )
    println(result)
}