package y2024.q2406_divide_intervals_into_minimum_number_of_groups

import java.util.*

class Solution {
    /**
     * - Time complexity: O(N)
     * - Space complexity: O(N)
     */
    fun minGroups(intervals: Array<IntArray>): Int {
        // sort `intervals` using the interval start
        intervals.sortBy { it[0] }

        // init a PQ to store the end bounds of groups
        // (use PQ instead of List: auto-sort the biggest end bound into the end)
        val endBounds = PriorityQueue<Int>()

        // add first group (contains first interval)
        var groupCount = 1
        endBounds.add(intervals[0][1])

        // loop through the rest intervals to check add groups
        for (i in 1..intervals.size - 1) {
            if (endBounds.peek() < intervals[i][0]) {
                // the last group end bound < this interval start
                // this interval can belong to the last group
                // poll end bound
                endBounds.poll()
                // replace new end bound using this interval end
                endBounds.add(intervals[i][1])
            } else {
                // the last group end bound >= this interval start (intersected)
                // must create a new group for this interval
                groupCount++
                endBounds.add(intervals[i][1])
            }
        }

        return groupCount
    }
}

fun main() {
    val result = Solution().minGroups(
        arrayOf(
            intArrayOf(1, 2),
            intArrayOf(1, 2),
        )
    )
    println(result)
}