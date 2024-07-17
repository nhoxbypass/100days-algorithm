package y2024.q1701_average_waiting_time


class Solution {
    fun averageWaitingTime(customers: Array<IntArray>): Double {
        if (customers.isEmpty())
            return 0.0

        var totalWaitTime = 0.0
        var prevOrderDoneTime = 0
        val n = customers.size
        for (i in 0 until n) {
            // calculate waiting time of curr customer
            // currOrderDoneTime = max(currArriveTime, prevOrderDoneTime) + currPreparationTime
            val currOrderDoneTime = (customers[i][0].coerceAtLeast(prevOrderDoneTime)) + customers[i][1]
            val waitTime = currOrderDoneTime - customers[i][0]
            // increase total waiting time
            totalWaitTime += waitTime
            // mark new done time
            prevOrderDoneTime = currOrderDoneTime
        }

        return totalWaitTime / n
    }
}


fun main() {
    val customers = arrayOf(intArrayOf(1, 2), intArrayOf(2, 5), intArrayOf(4, 3))
    val res = Solution().averageWaitingTime(customers)
    println(res)
}