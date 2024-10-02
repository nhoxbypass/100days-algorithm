package y2024.q1331_rank_transform_of_an_array

import java.util.*

/**
 * - Time complexity: O(1)
 * - Space complexity: O(N)
 */
class Solution {
    fun arrayRankTransform(arr: IntArray): IntArray {
        // clone items to new array and sorted
        val sortedArr = arr.withIndex().sortedBy { it.value }

        // find the rank
        val rankArr = IntArray(arr.size)
        var currRank = 1
        for (i in sortedArr.indices) {
            if (i > 0 && sortedArr[i].value != sortedArr[i - 1].value) {
                currRank++
            }
            rankArr[sortedArr[i].index] = currRank
        }

        return rankArr
    }

    fun arrayRankTransformOld(arr: IntArray): IntArray {
        // filter duplicated items and sort
        val sortedSet = arr.toSortedSet()

        // find the rank
        val rankArr = IntArray(arr.size)
        var lowerRankCount: Int
        for (i in arr.indices) {
            // count the number of item smaller than curr number
            lowerRankCount = countLower(sortedSet, arr[i])
            // rank = lower count + 1
            rankArr[i] = (lowerRankCount + 1)
        }
        return rankArr
    }

    private fun countLower(input: SortedSet<Int>, threshold: Int): Int {
        if (input.isEmpty()) return 0
        var count = 0
        for (element in input) {
            if (element < threshold) {
                count++
            } else {
                break
            }
        }
        return count
    }
}

fun main() {
    val result = Solution().arrayRankTransform(
        intArrayOf(
            37, 12, 28, 9, 100, 56, 80, 5, 12
        )
    )
    println(result)
}