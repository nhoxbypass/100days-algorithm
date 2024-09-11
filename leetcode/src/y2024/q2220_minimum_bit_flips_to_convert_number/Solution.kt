package y2024.q2220_minimum_bit_flips_to_convert_number

class Solution {
    /**
     * - Time complexity: O(N)
     * - Space complexity: O(1)
     */
    fun minBitFlips(start: Int, goal: Int): Int {
        // convert start/goal number to binary string
        val startStr = Integer.toBinaryString(start)
        val goalStr = Integer.toBinaryString(goal)

        // calculate flip count based on goal string
        var startIdx = startStr.length - 1
        var flipCount = 0
        for (goalIdx in goalStr.length - 1 downTo 0) {
            val startC = startStr.getOrNull(startIdx) ?: '0'
            val goalC = goalStr[goalIdx]
            if (startC != goalC) {
                // different bit
                // flip
                flipCount++
            }
            startIdx--
        }

        // if start string > goal string
        // calculate flip count for the rest '1' bits in start string
        for (i in startIdx downTo 0) {
            val startC = startStr[i]
            if (startC == '1') {
                // flip to '0'
                flipCount++
            } else {
                // bit '0' will be ignored
            }
        }

        return flipCount
    }
}

fun main() {
    val res = Solution().minBitFlips(
        10,
        7
    )
    println(res)
}