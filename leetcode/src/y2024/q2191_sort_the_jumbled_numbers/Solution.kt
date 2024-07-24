package y2024.q2191_sort_the_jumbled_numbers

class Solution {
    /**
     * - Time complexity: O(N*Log(N))
     * - Space complexity: O(N)
     */
    fun sortJumbled(mapping: IntArray, nums: IntArray): IntArray {
        // loop through the `nums` input array to calculate & build a list of mapping values
        // List<Pair<index, mapping value>>
        val mappingValues = ArrayList<Pair<Int, Int>>(nums.size)
        var idx = 0
        nums.forEach {
            mappingValues.add(Pair(idx, mapNumber(mapping, it)))
            idx++
        }

        // sorting the list based on mapping values
        // to make it become a list of sorted indices
        mappingValues.sortBy { it.second }

        // build new IntArray result based on the sorted indices
        return IntArray(nums.size) { nums[mappingValues[it].first] }
    }

    private fun mapNumber(mapping: IntArray, num: Int): Int {
        var mappingVal = 0
        num.toString().forEach {
            mappingVal = mappingVal * 10 + mapping[it.digitToInt()]
        }
        return mappingVal
    }
}

fun main() {
    val res = Solution().sortJumbled(
        intArrayOf(8, 9, 4, 0, 2, 1, 3, 5, 7, 6),
        intArrayOf(991, 338, 38)
    )
    println(res)
}