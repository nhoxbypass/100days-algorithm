package y2024.q179_largest_number

class Solution {
    /**
     * - Time complexity: O(N∗Log(N))
     * - Space complexity: O(N)
     */
    fun largestNumber(nums: IntArray): String {
        val sortedNums = nums.map {
            // map to string
            it.toString()
        }.sortedWith { o1, o2 ->
            // sort DESC
            // add 2 string (o1+o2) before compare because:
            // Ex: o1=3, o2=30 -> "330" > "303"
            (o2 + o1).compareTo((o1 + o2))
        }

        if (sortedNums[0] == "0") {
            // the `sortedNums` is sorted DESC
            // if the first string is "0" -> the rest will be "0"
            // fix for case [0,0] -> "00"
            return "0"
        }

        return sortedNums.joinToString("")
    }
}

fun main() {
    val res = Solution().largestNumber(intArrayOf(3, 301, 321, 5, 9))
    println(res)
}