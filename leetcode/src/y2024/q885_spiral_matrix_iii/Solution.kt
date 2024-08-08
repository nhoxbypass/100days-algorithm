package y2024.q885_spiral_matrix_iii

class Solution {
    /**
     * - Time complexity: O(rows * cols)
     * - Space complexity: O(rows * cols)
     */
    fun spiralMatrixIII(rows: Int, cols: Int, rStart: Int, cStart: Int): Array<IntArray> {
        val totalStep = rows * cols
        val path = ArrayList<IntArray>(totalStep)

        // add start pos (rStart, cStart)
        checkToAddPath(path, rStart, cStart, rows, cols)

        var currRow = rStart
        var currCol = cStart
        var radius = 1
        while (true) {
            if (travelled == totalStep) {
                // completed
                break
            }

            // move right
            repeat(radius) {
                currCol++
                checkToAddPath(path, currRow, currCol, rows, cols)
            }

            // move down
            repeat(radius) {
                currRow++
                checkToAddPath(path, currRow, currCol, rows, cols)
            }

            // increase spiral radius
            radius++

            // move left
            repeat(radius) {
                currCol--
                checkToAddPath(path, currRow, currCol, rows, cols)
            }

            // move up
            repeat(radius) {
                currRow--
                checkToAddPath(path, currRow, currCol, rows, cols)
            }

            // increase spiral radius
            radius++
        }

        return path.toTypedArray()
    }

    private var travelled = 0

    private fun checkToAddPath(path: ArrayList<IntArray>, r: Int, c: Int, rows: Int, cols: Int) {
        if ((r in 0..<rows) && (c in 0..<cols)) {
            path.add(intArrayOf(r, c))
            travelled++
        }
    }
}

fun main() {
    val res = Solution().spiralMatrixIII(
        5,
        6,
        1,
        4
    )
    println(res)
}