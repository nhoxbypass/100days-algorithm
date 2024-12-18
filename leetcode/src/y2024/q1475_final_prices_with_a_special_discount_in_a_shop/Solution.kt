package y2024.q1475_final_prices_with_a_special_discount_in_a_shop

class Solution {
    /**
     * - Time complexity: O(N^2)
     * - Space complexity: O(1)
     */
    fun finalPrices(prices: IntArray): IntArray {
        val size = prices.size

        for (i in 0..<size) {
            val currPrice = prices[i]
            for (j in i + 1..<size) {
                if (prices[j] <= currPrice) {
                    // calculate discount & put the price back to original list
                    prices[i] = currPrice - prices[j]
                    break
                }
            }
        }

        return prices
    }
}

fun main() {
    val res = Solution().finalPrices(intArrayOf(8, 4, 6, 2, 3))
    println(res)
}