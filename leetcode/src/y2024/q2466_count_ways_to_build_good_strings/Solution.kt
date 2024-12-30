package y2024.q2466_count_ways_to_build_good_strings

class Solution {
    /**
     * - Time complexity: O(N)
     * - Space complexity: O(N)
     */
    fun countGoodStrings(low: Int, high: Int, zero: Int, one: Int): Int {
        // modulus to keep the result within bounds of a large prime number
        val MOD = 1000_000_000 + 7

        val dp = IntArray(high + 1).also { it[0] = 1 }
        var res = 0
        for (i in 1..high) {
            if (i >= zero) {
                dp[i] = (dp[i] + dp[i - zero]) % MOD
            }
            if (i >= one) {
                dp[i] = (dp[i] + dp[i - one]) % MOD
            }
            if (i >= low) {
                res = (res + dp[i]) % MOD
            }
        }
        return res
    }
}

fun main() {
    val res = Solution().countGoodStrings(3, 3, 1, 1)
    println(res)
}