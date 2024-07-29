package y2024.q1395_count_number_of_teams

class Solution {
    /**
     * - Time complexity: O(N^2)
     * - Space complexity: O(1)
     */
    fun numTeams(rating: IntArray): Int {
        val size = rating.size

        if (size <= 2)
            return 0

        // because both order is valid
        // rating[i] < rating[j] < rating[k] OR rating[i] > rating[j] > rating[k]
        // we rely on j & rating[j]
        var validCount = 0
        for (j in 1..size - 2) {
            val curr = rating[j]

            // count first part ([i] items)
            var iLowCount = 0
            var iHighCount = 0
            for (i in 0..j - 1) {
                if (rating[i] < curr) {
                    iLowCount++
                }
                if (rating[i] > curr) {
                    iHighCount++
                }
            }

            // count second part ([k] items)
            var kLowCount = 0
            var kHighCount = 0
            for (k in j + 1..size - 1) {
                if (rating[k] < curr) {
                    kLowCount++
                }
                if (rating[k] > curr) {
                    kHighCount++
                }
            }

            // rating[i] < rating[j] < rating[k]
            if (iLowCount > 0 && kHighCount > 0) {
                validCount += (iLowCount * kHighCount)
            }
            // rating[i] > rating[j] > rating[k]
            if (iHighCount > 0 && kLowCount > 0) {
                validCount += (iHighCount * kLowCount)
            }
        }

        return validCount
    }

    /**
     * - Time complexity: O(N^3)
     * - Space complexity: O(1)
     */
    fun numTeams1(rating: IntArray): Int {
        val size = rating.size

        if (size <= 2)
            return 0

        var validCount = 0
        for (i in 0..size - 3) {
            for (j in i + 1..size - 2) {
                for (k in j + 1..size - 1) {
                    val validTeam = (rating[i] < rating[j] && rating[j] < rating[k])
                            || (rating[i] > rating[j] && rating[j] > rating[k])
                    if (validTeam) {
                        validCount++
                    }
                }
            }
        }

        return validCount
    }
}

fun main() {
    val res = Solution().numTeams(
        intArrayOf(2,5,3,4,1)
    )
    println(res)
}