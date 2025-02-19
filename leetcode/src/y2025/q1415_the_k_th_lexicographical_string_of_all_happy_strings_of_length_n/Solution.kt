package y2025.q1415_the_k_th_lexicographical_string_of_all_happy_strings_of_length_n

class Solution {
    /**
     * - Time complexity: O(N)
     * - Space complexity: O(N)
     */
    private val possibleLetter = listOf('a', 'b', 'c')

    fun getHappyString(n: Int, k: Int): String {
        // generate possible happy strings
        val happyStrings = ArrayList<String>()
        generateHappyStrings(n, "", happyStrings)

        // sort in lexicographical order
        val sortedHappyStrings = happyStrings.sorted()

        // return string at [k]
        return sortedHappyStrings.getOrNull(k - 1) ?: ""
    }

    private fun generateHappyStrings(n: Int, currString: String, happyStrings: MutableList<String>) {
        if (currString.length == n) {
            happyStrings.add(currString)
            return
        }

        for (letter in possibleLetter) {
            if (currString.isEmpty() || currString.last() != letter) {
                generateHappyStrings(n, currString + letter, happyStrings)
            }
        }
    }
}

fun main() {
    val res = Solution().getHappyString(
        3, 9
    )
    println(res)
}