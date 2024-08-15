package y2024.q860_lemonade_change

import kotlin.math.min

class Solution {
    /**
     * - Time complexity: O(N)
     * - Space complexity: O(N)
     */
    fun lemonadeChange(bills: IntArray): Boolean {
        val wallet = hashMapOf(
            5 to 0,
            10 to 0,
            20 to 0
        )

        bills.forEach { bill ->
            var changeNeeded = bill - 5
            if (changeNeeded > 0) {
                // check to return change money to customer
                changeNeeded = calculateChange(changeNeeded, wallet, 20)
                changeNeeded = calculateChange(changeNeeded, wallet, 10)
                changeNeeded = calculateChange(changeNeeded, wallet, 5)
                if (changeNeeded > 0) {
                    // still cannot return change money to customer
                    return false
                }
            }
            // add customer's bill into our wallet
            wallet[bill] = wallet[bill]!! + 1
        }
        return true
    }

    private fun calculateChange(changeNeeded: Int, wallet: MutableMap<Int, Int>, faceValue: Int): Int {
        val neededCount = changeNeeded / faceValue

        if (neededCount <= 0) return changeNeeded

        val currWalletCount = wallet[faceValue]!!
        val changeCount = min(neededCount, currWalletCount)
        wallet.put(faceValue, currWalletCount - changeCount)
        return changeNeeded - (changeCount * faceValue)
    }
}

fun main() {
    val res = Solution().lemonadeChange(
        intArrayOf(5, 5, 5, 10, 20)
    )
    println(res)
}