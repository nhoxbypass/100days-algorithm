package y2024.q1518_water_bottles

class Solution {
    fun numWaterBottles(numBottles: Int, numExchange: Int): Int {
        // drink initial bottles
        var drinkCount = numBottles
        var currEmptyBottles = numBottles
        while (true) {
            // exchange new bottles (from empty -> full)
            val newFullBottles = currEmptyBottles / numExchange
            if (newFullBottles == 0) {
                // oops
                break
            }
            // drink new full bottles
            drinkCount += newFullBottles
            // calculate empty bottles for new exchange
            currEmptyBottles = newFullBottles + (currEmptyBottles % numExchange)
        }
        return drinkCount
    }
}


fun main() {
    val res = Solution().numWaterBottles(5, 6)
    println(res)
}