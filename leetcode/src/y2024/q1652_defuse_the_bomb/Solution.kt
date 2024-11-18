package y2024.q1652_defuse_the_bomb

import kotlin.math.abs

class Solution {
    /**
     * - Time complexity: O(N * K)
     * - Space complexity: O(N)
     */
    fun decrypt(code: IntArray, k: Int): IntArray {
        val n = code.size
        val absK = abs(k)
        val result = IntArray(n)

        if (k == 0)
            return result

        for (i in code.indices) {
            var sum = 0
            for (offset in 1..absK) {
                // find the offset of the item needed to be sum
                val idx = if (k > 0) {
                    (i + offset) % n
                } else {
                    (n + i - offset) % n
                }
                // sum
                sum += code[idx]
            }
            // assign the calculated result
            result[i] = sum
        }

        return result
    }
}

fun main() {
    val result = Solution().decrypt(
        intArrayOf(5, 7, 1, 4), 3
    )
    println(result)
}