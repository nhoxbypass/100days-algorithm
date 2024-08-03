package y2024.q1460_make_two_arrays_equal_by_reversing_subarrays

class Solution {
    /**
     * - Time complexity: O(N)
     * - Space complexity: O(N)
     */
    fun canBeEqual(target: IntArray, arr: IntArray): Boolean {
        // calculate the frequency count of item in target array
        val countMap = hashMapOf<Int, Int>()
        target.forEach { item ->
            countMap[item] = countMap.getOrDefault(item, 0) + 1
        }

        // loop through [arr] to:
        // - decrease the freq count if exists
        // - if the freq count <= 0 -> invalid
        arr.forEach { item ->
            val c = countMap.getOrDefault(item, 0)
            if (c <= 0) {
                return false
            }
            countMap[item] = c - 1
        }

        return true
    }

    /**
     * - Time complexity: O(Nlog(N))
     * - Space complexity: O(1)
     */
    fun canBeEqual2(target: IntArray, arr: IntArray): Boolean {
        // sort both arrays
        target.sort()
        arr.sort()

        return target.contentEquals(arr)
    }
}

fun main() {
    val res = Solution().canBeEqual(
        intArrayOf(1, 2, 3, 4),
        intArrayOf(2, 4, 1, 3)
    )
    println(res)
}