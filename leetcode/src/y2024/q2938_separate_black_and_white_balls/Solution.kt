package y2024.q2938_separate_black_and_white_balls

class Solution {
    /**
     * - Time complexity: O(N)
     * - Space complexity: O(1)
     */
    fun minimumSteps(s: String): Long {
        // convert input string to bits array
        val bits = s.toCharArray()

        // the boundary between '0' and '1' bits
        var boundary = 0
        // loop to swap bit '0' <-> bit at boundary
        // to move '0' to the beginning
        var swapStep = 0L
        for (i in bits.indices) {
            val bit = bits[i]
            if (bit == '0') {
                // bit '0' at the end -> check to swap
                if (bits[boundary] == '1') {
                    // bits[boundary] is '1'
                    // swap
                    bits[i] = bits[boundary]
                    bits[boundary] = bit
                    // increase swap steps
                    // because each time, we can only swap 2 adjacent bit -> the number of swaps require is (i - boundary)
                    swapStep += (i - boundary)
                } else {
                    // bits[boundary] is '0'
                }
                // move boundary 1 step (toward the end)
                boundary++
            } else {
                // bit '1' at the end -> don't need to swap
            }
        }

        return swapStep
    }
}

fun main() {
    val result = Solution().minimumSteps(
        "100"
    )
    println(result)
}