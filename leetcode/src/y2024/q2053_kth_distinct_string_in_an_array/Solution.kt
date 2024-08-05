package y2024.q2053_kth_distinct_string_in_an_array

class Solution {
    /**
     * - Time complexity: O(N)
     * - Space complexity: O(N)
     */
    fun kthDistinct(arr: Array<String>, k: Int): String {
        // count the frequency of each string
        val countMap = mutableMapOf<String, Int>()
        for (s in arr) {
            countMap[s] = countMap.getOrDefault(s, 0) + 1
        }

        // collect distinct strings (with frequency 1)
        val distinctStr = mutableListOf<String>()
        for (s in arr) {
            if (countMap[s] == 1) {
                distinctStr.add(s)
            }
        }

        // return the k-th distinct string (if it exists)
        return if (distinctStr.size >= k) {
            distinctStr[k - 1]
        } else {
            ""
        }
    }
}

fun main() {
    val res = Solution().kthDistinct(
        arrayOf("d", "b", "c", "b", "c", "a"),
        2
    )
    println(res)
}