package y2024.q769_max_chunks_to_make_sorted

class Solution {
    /**
     * - Time complexity: O(N^2)
     * - Space complexity: O(1)
     */
    fun maxChunksToSorted(arr: IntArray): Int {
        var chunkCount = 0
        var max = Integer.MIN_VALUE
        for (idx in arr.indices) {
            // the array `arr` is a permutation of [0, n - 1] -> a number will be located at number after sorting
            // -> if its original index smaller than its value, it can't be split before reaching its value
            // -> otherwise it will be grouped into an earlier place.
            max = maxOf(max, arr[idx])
            if (max == idx) {
                chunkCount++
                max = Integer.MIN_VALUE
            }
        }
        return chunkCount
    }
}

fun main() {
    val res = Solution().maxChunksToSorted(intArrayOf(4, 3, 2, 1, 0))
    println(res)
}