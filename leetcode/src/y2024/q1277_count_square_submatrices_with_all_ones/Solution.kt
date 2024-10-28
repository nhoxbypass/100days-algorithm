package y2024.q1277_count_square_submatrices_with_all_ones

class Solution {
    /**
     * - Time complexity: O(N * Max(M))
     * - Space complexity: O(N)
     */
    fun countSquares(matrix: Array<IntArray>): Int {
        val m = matrix.size
        val n = matrix[0].size

        // init DP matrix (M+1)x(N+1) that filled with `0` values
        val dp: Array<IntArray> = Array(m + 1) { IntArray(n + 1) { 0 } }

        // loop through the matrix to count squares
        var count = 0
        for (i in 1..m) {
            for (j in 1..n) {
                if (matrix[i - 1][j - 1] == 1) {
                    val minInSquare = minOf(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1])
                    dp[i][j] = minInSquare + 1
                    count += dp[i][j]
                } else {
                    // do nothing
                }
            }
        }

        return 0
    }
}

fun main() {
    val result = Solution().countSquares(
        arrayOf(
            intArrayOf(0, 1, 1, 1),
            intArrayOf(1, 1, 1, 1),
            intArrayOf(0, 1, 1, 1)
        )
    )
    println(result)
}