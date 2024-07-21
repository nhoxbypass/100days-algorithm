package y2024.q1605_find_valid_matrix_given_row_and_column_sums


class Solution {
    fun restoreMatrix(rowSums: IntArray, colSums: IntArray): Array<IntArray> {
        val rowCount = rowSums.size
        val colCount = colSums.size

        val matrix = Array(rowCount) { IntArray(colCount) { 0 } }

        for (rowIndex in 0 until rowCount) {
            for (colIndex in 0 until colCount) {
                // find the smallest rowSum or colSum, and let it be X
                val x = minOf(rowSums[rowIndex], colSums[colIndex])

                if (x == 0) {
                    continue
                }

                // place that number in the matrix
                matrix[rowIndex][colIndex] = x

                // subtract X from rowSum and colSum
                rowSums[rowIndex] -= x
                colSums[colIndex] -= x

                // continue until all the sums are satisfied
            }
        }

        return matrix
    }
}

fun main() {
    val res = Solution().restoreMatrix(
        intArrayOf(3, 8),
        intArrayOf(4, 7)
    )
    println(res)
}