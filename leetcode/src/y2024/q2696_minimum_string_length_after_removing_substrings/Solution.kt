package y2024.q2696_minimum_string_length_after_removing_substrings

import java.util.LinkedList

/**
 * - Time complexity: O(N)
 * - Space complexity: O(N)
 */
class Solution {
    fun minLength(s: String): Int {
        // init stack to store result chars
        // this stack will NOT contain consecutive 'A','B' or 'C','D'
        val charStack = LinkedList<Char>()

        s.forEach { c ->
            if (c == 'B') {
                // meet 'B' -> check prev char whether 'A'
                val prevC = charStack.peek()
                if (prevC == 'A') {
                    // "AB" found
                    charStack.pop()
                } else {
                    // not found, add to stack
                    charStack.push(c)
                }
            } else if (c == 'D') {
                // meet 'D' -> check prev char whether 'C'
                val prevC = charStack.peek()
                if (prevC == 'C') {
                    // "CD" found
                    charStack.pop()
                } else {
                    // not found, add to stack
                    charStack.push(c)
                }
            } else {
                // normal char, add to stack
                charStack.push(c)
            }
        }

        return charStack.size
    }
}

fun main() {
    val result = Solution().minLength(
        "ABFCACDB"
    )
    println(result)
}