package y2024.q539_minimum_time_difference

import java.time.LocalTime
import java.time.format.DateTimeFormatter
import kotlin.math.abs
import kotlin.math.min

class Solution {
    /**
     * - Time complexity: O(NLogN)
     * - Space complexity: O(N)
     */
    fun findMinDifference(timePoints: List<String>): Int {
        // define the format to match "HH:MM"
        val formatter = DateTimeFormatter.ofPattern("HH:mm")

        // build list of current minute of day (offset to 00:00)
        val tsList = ArrayList<Int>()
        timePoints.forEach { point ->
            val minuteOfDay = LocalTime.parse(point, formatter).toSecondOfDay() / 60
            tsList.add(minuteOfDay)
        }

        // sort the list
        tsList.sort()

        // find the min diff
        var currMinDiff = Int.MAX_VALUE
        for (i in 1..<tsList.size) {
            currMinDiff = min(currMinDiff, tsList[i] - tsList[i - 1])
            if (currMinDiff == 0) break
        }

        // find "special" min diff between
        // - smallest minute of day (smallest offset to 00:00) + 1 DAY (24 * 60)
        // - biggest minute of day (biggest offset to 00:00)
        val specialMinDiff = (tsList.first() + 24 * 60) - tsList.last()

        return min(currMinDiff, specialMinDiff)
    }

    fun findMinDifferenceOld(timePoints: List<String>): Int {
        // define the format to match "HH:MM"
        val formatter = DateTimeFormatter.ofPattern("HH:mm")

        // build list of current minute of day
        val tsList = ArrayList<Int>()
        timePoints.forEach { point ->
            val minuteOfDay = LocalTime.parse(point, formatter).toSecondOfDay() / 60
            tsList.add(minuteOfDay)
        }

        // sort the list
        //tsList.sort()

        // find the min diff
        var currMinDiff = Int.MAX_VALUE
        for (i in 0..<tsList.size - 1) {
            for (j in i + 1..<tsList.size) {
                val rawDiff = abs(tsList[i] - tsList[j])
                val diff = if (rawDiff <= 720) {
                    // before 12h
                    rawDiff
                } else {
                    // after 12h
                    1440 - rawDiff
                }
                currMinDiff = min(currMinDiff, diff)
            }
            if (currMinDiff == 0) break
        }

        return currMinDiff
    }
}

fun main() {
    val res = Solution().findMinDifference(
        listOf(
            "23:59",
            "00:00"
        )
    )
    println(res)
}