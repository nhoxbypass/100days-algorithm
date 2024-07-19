package y2024.q1380_lucky_numbers_in_a_matrix

import kotlin.math.max
import kotlin.math.min

class Solution {
    fun luckyNumbers(matrix: Array<IntArray>): List<Int> {
        if (matrix.isEmpty() || matrix[0].isEmpty()) return emptyList()

        val m = matrix.size
        val n = matrix[0].size

        val minRowItems = HashSet<Int>(m)
        val maxColItems = MutableList(n) { -1 }
        for (i in 0..<m) {
            var currMinRow = Int.MAX_VALUE
            for (j in 0..<n) {
                val item = matrix[i][j]
                currMinRow = min(currMinRow, item)
                maxColItems[j] = max(maxColItems[j], item)
            }
            minRowItems.add(currMinRow)
        }

        val luckyNumbers = ArrayList<Int>()
        maxColItems.forEach {
            if (minRowItems.contains(it)) {
                luckyNumbers.add(it)
            }
        }

        return luckyNumbers
    }
}

fun main() {
    val matrix = arrayOf(
        intArrayOf(3, 7, 8),
        intArrayOf(9, 11, 13),
        intArrayOf(15, 16, 17)
    )
    val res = Solution().luckyNumbers(matrix)
    println(res)
}