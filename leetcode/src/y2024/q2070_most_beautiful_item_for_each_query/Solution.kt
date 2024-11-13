package y2024.q2070_most_beautiful_item_for_each_query

import java.util.*
import kotlin.math.max

class Solution {
    /**
     * - Time complexity: O(NLogN)
     * - Space complexity: O(N)
     */
    fun maximumBeauty(items: Array<IntArray>, queries: IntArray): IntArray {
        // sort the list of items based on their price
        items.sortBy { it[0] }

        val n = queries.size
        val answer = IntArray(n)
        val sortedBeauty = TreeMap<Int, Int>() // TreeMap<Price, MaxBeauty>
        var maxBeauty = 0
        for (i in items.indices) {
            // the `items` is sorted
            // -> for items with the same price -> we will collect the item that appears later
            maxBeauty = max(maxBeauty, items[i][1])
            sortedBeauty[items[i][0]] = maxBeauty
        }

        for (i in queries.indices) {
            answer[i] = sortedBeauty.floorEntry(queries[i])?.value ?: 0
        }

        return answer
    }
}

fun main() {
    val result = Solution().maximumBeauty(
        arrayOf(intArrayOf(1, 2), intArrayOf(3, 2), intArrayOf(2, 4), intArrayOf(5, 6), intArrayOf(3, 5)),
        intArrayOf(1, 2, 3, 4, 5, 6)
    )
    println(result)
}