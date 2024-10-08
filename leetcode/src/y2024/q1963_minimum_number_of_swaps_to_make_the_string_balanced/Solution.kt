package y2024.q1963_minimum_number_of_swaps_to_make_the_string_balanced

import java.util.*

/**
 * - Time complexity: O(N)
 * - Space complexity: O(N)
 */
class Solution {
    fun minSwaps(s: String): Int {
        // build a brackets stack that contain wrong-order brackets
        val charStack = Stack<Char>()
        // filter the matching nearby bracket "[]"
        // push the wrong-order brackets into stack
        s.forEach { c ->
            if (c == '[') {
                // push '['
                charStack.push(c)
            } else if (c == ']') {
                if (charStack.isNotEmpty() && charStack.peek() == '[') {
                    // matching nearby bracket "[]"
                    // pop '[' to match with ']'
                    charStack.pop()
                } else {
                    // push ']'
                    charStack.push(c)
                }
            } else {
                // cannot happen
            }
        }

        // count open/close brackets
        var openBrk = 0
        var closeBrk = 0
        while (!charStack.empty()) {
            val c = charStack.pop()
            if (c == '[') {
                openBrk++
            } else if (c == ']') {
                closeBrk++
            }
        }

        // number brackets need to move = (open_brackets+1)/2 + (close_brackets+1)/2
        val numberBrkNeedToMove = ((openBrk + 1) / 2) + ((closeBrk + 1) / 2)
        // count pair instead of single wrong-order bracket
        return numberBrkNeedToMove / 2
    }
}

fun main() {
    val result = Solution().minSwaps(
        "]]][[["
    )
    println(result)
}