package y2025.q2657_find_the_prefix_common_array_of_two_arrays

class Solution {
    /**
     * - Time complexity: O(N)
     * - Space complexity: O(N)
     */
    fun findThePrefixCommonArray(A: IntArray, B: IntArray): IntArray {
        val n = A.size
        // array to count common numbers
        val count = IntArray(n + 1) { 0 }
        var commonCount = 0
        // result array
        val C = IntArray(n) { 0 }

        for (i in A.indices) {
            val aIdx = A[i]
            val bIdx = B[i]
            // because 1 <= A[i], B[i] <= n
            // -> we can use A[i]/B[i] as index to count
            count[aIdx]++
            count[bIdx]++

            // check the number at A[i]
            if (count[aIdx] == 2) {
                // it appears at least 2 times
                // increase common count
                commonCount++
            }

            // check the number at B[i]
            if (aIdx != bIdx) {
                if (count[bIdx] == 2) {
                    // it appears at least 2 times
                    // increase common count
                    commonCount++
                }
            }

            // assign common count to C[i]
            C[i] = commonCount
        }

        return C
    }
}

fun main() {
    val res = Solution().findThePrefixCommonArray(
        intArrayOf(1, 3, 2, 4),
        intArrayOf(3, 1, 2, 4)
    )
    println(res)
}