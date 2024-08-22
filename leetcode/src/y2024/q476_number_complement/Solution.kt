package y2024.q476_number_complement

import kotlin.math.pow

class Solution {
    /**
     * - Time complexity: O(N)
     * - Space complexity: O(1)
     */
    fun findComplement(num: Int): Int {
        val binaryStr = Integer.toBinaryString(num)
        var result = 0.0
        var currPow = binaryStr.length - 1
        binaryStr.forEach { bit ->
            if (bit == '0') {
                // flip to '1'
                result += 2.0.pow(currPow)
            } else {
                // flip to '0'
            }
            currPow--
        }
        return result.toInt()
    }
}

fun main() {
    val res = Solution().findComplement(
        5
    )
    println(res)
}