package y2024.q1636_sort_array_by_increasing_frequency

class Solution {
    /**
     * - Time complexity: O(NLogN)
     * - Space complexity: O(n)
     */
    fun frequencySort(nums: IntArray): IntArray {
        if (nums.size == 1) return nums

        // build frequency map
        val freqMap = HashMap<Int, Int>()
        for (num in nums) {
            freqMap[num] = (freqMap.getOrDefault(num, 0) + 1)
        }

        // sort input array using frequency map
        return nums.sortedWith(object : Comparator<Int> {
            override fun compare(n1: Int, n2: Int): Int {
                val n1Freq = freqMap[n1]!!
                val n2Freq = freqMap[n2]!!
                if (n1Freq == n2Freq) {
                    // equal freq
                    // sort decreasing order by value
                    return n2.compareTo(n1)
                }
                // sort increasing order by freq
                return n1Freq.compareTo(n2Freq)
            }
        }).toIntArray()
    }
}

fun main() {
    val res = Solution().frequencySort(
        intArrayOf(1,1,2,2,2,3)
    )
    println(res)
}