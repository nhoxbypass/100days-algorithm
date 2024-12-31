package y2024.q938_minimum_cost_for_tickets

class Solution {
    /**
     * - Time complexity: O(N)
     * - Space complexity: O(N)
     */
    fun mincostTickets(days: IntArray, costs: IntArray): Int {
        // list target days that we need to travel
        val travelDays = days.toSet()
        val lastTravelDay = days.last()

        // cached min travel cost
        // minCost[i] = min ticket cost to travel at day 'i'
        val minCost = IntArray(lastTravelDay + 1) { Int.MAX_VALUE }

        minCost[0] = 0
        for (day in 1..lastTravelDay) {
            if (day in travelDays) {
                // this day is a target travel day
                // calculate min travel cost, using min of:
                // - cost at [day-1]  + ticket price 1D
                // - cost at [day-7]  + ticket price 7D
                // - cost at [day-30] + ticket price 30D
                minCost[day] = minOf(
                    minCost[(day - 1).coerceAtLeast(0)] + costs[0],
                    minCost[(day - 7).coerceAtLeast(0)] + costs[1],
                    minCost[(day - 30).coerceAtLeast(0)] + costs[2]
                )
            } else {
                // a normal day (no travel)
                minCost[day] = minCost[day - 1]
            }
        }

        return minCost[days.last()]
    }
}

fun main() {
    val res = Solution().mincostTickets(intArrayOf(1, 4, 6, 7, 8, 20), intArrayOf(2, 7, 15))
    println(res)
}