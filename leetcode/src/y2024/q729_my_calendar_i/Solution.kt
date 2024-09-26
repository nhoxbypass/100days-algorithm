package y2024.q729_my_calendar_i

import java.util.TreeSet

/**
 * - Time complexity: O(LogN)
 * - Space complexity: O(N)
 */
class MyCalendar() {
    private val bookingList = TreeSet<Booking>()

    private class Booking(val start: Int, val end: Int) : Comparable<Booking> {
        override fun compareTo(other: Booking): Int {
            if (end <= other.start) {
                // [curr] [other]
                return -1
            }
            if (other.end <= start) {
                // [other] [curr]
                return 1
            }
            return 0
        }

        override fun equals(other: Any?): Boolean {
            if (other == null || other !is Booking) return false
            if (start < other.end && end > other.start) {
                // consider duplicated book as equals
                return true
            }
            return false
        }
    }

    fun book(start: Int, end: Int): Boolean {
        return bookingList.add(Booking(start, end))
    }
}

/**
 * - Time complexity: O(N)
 * - Space complexity: O(N)
 */
class MyCalendarOld() {
    private val bookingList = ArrayList<Pair<Int, Int>>()

    fun book(start: Int, end: Int): Boolean {
        bookingList.forEach {
            if (start < it.second && end > it.first) {
                // duplicated
                return false
            }
        }

        // add new booking
        bookingList.add(Pair(start, end))

        return true
    }
}

fun main() {
    val bookingList = arrayOf(
        Pair(10, 20),
        Pair(15, 25),
        Pair(20, 30)
    )
    val calendar = MyCalendar()
    bookingList.forEach {
        val res = calendar.book(it.first, it.second)
        println(res)
    }
}