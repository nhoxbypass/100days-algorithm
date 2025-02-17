package y2025.q1079_letter_tile_possibilities

class Solution {
    /**
     * - Time complexity: O(N)
     * - Space complexity: O(1)
     */
    fun numTilePossibilities(tiles: String): Int {
        // calculate char frequencies
        val charFreq = IntArray(26)
        tiles.forEach { c ->
            charFreq[c - 'A']++
        }

        // backtracking to find & count string combinations
        return backtrack(charFreq)
    }

    private fun backtrack(charFreq: IntArray): Int {
        var count = 0
        for (i in charFreq.indices) {
            if (charFreq[i] > 0) {
                // increase the count
                count++
                // the current char at [i] is used
                // -> remove it by decreasing the char freq (only temporarily)
                charFreq[i]--
                // backtracking
                count += backtrack(charFreq)
                // restore the char freq after backtracking
                charFreq[i]++
            }
        }
        return count
    }
}

fun main() {
    val res = Solution().numTilePossibilities(
        "AAB"
    )
    println(res)
}