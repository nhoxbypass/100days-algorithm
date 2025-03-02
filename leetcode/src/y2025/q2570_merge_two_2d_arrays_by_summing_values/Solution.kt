package y2025.q2570_merge_two_2d_arrays_by_summing_values

class Solution {
    /**
     * - Time complexity: O(N)
     * - Space complexity: O(N)
     */
    fun mergeArrays(nums1: Array<IntArray>, nums2: Array<IntArray>): Array<IntArray> {
        // init Map<ID, sum>
        val mergedNums = LinkedHashMap<Int, Int>()

        // calculate sum for `num1` and `num2`
        nums1.forEach {
            val key = it[0]
            val value = it[1]
            mergedNums[key] = mergedNums.getOrDefault(key, 0) + value
        }
        nums2.forEach {
            val key = it[0]
            val value = it[1]
            mergedNums[key] = mergedNums.getOrDefault(key, 0) + value
        }

        // sort by ID
        // then convert the Map<ID, sum> to the expected array
        return mergedNums
            .toList()
            .sortedBy { it.first }
            .map { intArrayOf(it.first, it.second) }
            .toTypedArray()
    }
}

fun main() {
    val res = Solution().mergeArrays(
        arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(4, 5)),
        arrayOf(intArrayOf(1, 4), intArrayOf(3, 2), intArrayOf(4, 1))
    )
    println(res)
}