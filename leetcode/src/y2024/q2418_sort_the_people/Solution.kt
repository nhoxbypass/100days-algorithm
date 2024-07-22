package y2024.q2418_sort_the_people

import java.util.*

class Solution {
    /**
     * - Time complexity: O(NLogN)
     * - Space complexity: O(n)
     */
    fun sortPeople(names: Array<String>, heights: IntArray): Array<String> {
        // init sorted TreeMap<Height, Name> (Red-Black tree)
        // it's sorted according to the natural ordering of its keys (which is Height)
        val sortedNameMap = TreeMap<Int, String>(Collections.reverseOrder())

        // fill data <Height, Name>
        heights.forEachIndexed { index, height ->
            sortedNameMap[height] = names[index]
        }

        // convert to Array<String>
        return convertToTypedArray(sortedNameMap)
    }

    private fun convertToTypedArray(map: TreeMap<Int, String>): Array<String> {
        val result = Array(map.size) { "" }
        var index = 0
        map.values.forEach { value ->
            result[index++] = value
        }
        return result
    }
}

fun main() {
    val res = Solution().sortPeople(
        arrayOf("Mary", "John", "Emma"),
        intArrayOf(180, 165, 170)
    )
    println(res)
}