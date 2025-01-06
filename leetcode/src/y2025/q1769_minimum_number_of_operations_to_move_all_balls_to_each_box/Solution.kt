package y2025.q1769_minimum_number_of_operations_to_move_all_balls_to_each_box

import kotlin.math.abs

class Solution {
    /**
     * - Time complexity: O(N^2)
     * - Space complexity: O(N)
     */
    fun minOperations(boxes: String): IntArray {
        val n = boxes.length
        val answer = IntArray(n)

        // number of all boxes '1' on the LEFT of box[i]
        var leftCount = 0
        // number of all boxes '1' on the RIGHT of box[i]
        var rightCount = 0
        // total operation count (prefix sum)
        var operationSum = 0

        // travel from the beginning to calculate sum of all operations
        for (i in 0..<n) {
            if (boxes[i] == '1') {
                rightCount++
                operationSum += i
            }
        }

        // travel again to re-calculate the exact operation needed for each box[i]
        for (i in 0..<n) {
            answer[i] = operationSum
            if (boxes[i] == '1') {
                leftCount++
                rightCount--
            }
            // update total operation count
            // new count = current count - (1 operation * number of boxes '1' on the RIGHT)
            operationSum -= rightCount
            // new count = current count + (1 operation * number of boxes '1' on the LEFT)
            operationSum += leftCount
        }

        return answer
    }

    /**
     * - Time complexity: O(N^2)
     * - Space complexity: O(N)
     */
    fun minOperationsOld(boxes: String): IntArray {
        val n = boxes.length
        val answer = IntArray(n)
        for (i in 0..<n) {
            var moveCount = 0
            for (j in 0..<n) {
                if (boxes[j] == '1') {
                    moveCount += (abs(j - i))
                }
            }
            answer[i] = moveCount
        }
        return answer
    }
}

fun main() {
    val res = Solution().minOperations(
        "001011"
    )
    println(res)
}