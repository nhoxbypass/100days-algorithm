package y2025.q1408_string_matching_in_an_array

class Solution {
    /**
     * - Time complexity: O(N^2 * M)
     * - Space complexity: O(N)
     */
    fun stringMatching(words: Array<String>): List<String> {
        // sub-words result
        val result = ArrayList<String>()

        val n = words.size
        for (i in 0..<n) {
            val w = words[i]
            for (j in 0..<n) {
                if (i != j && words[j].contains(w)) {
                    result.add(w)
                    break
                }
            }
        }

        return result
    }
}

fun main() {
    val res = Solution().stringMatching(
        arrayOf("mass", "as", "hero", "superhero")
    )
    println(res)
}