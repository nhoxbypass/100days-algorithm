package y2024.q921_minimum_add_to_make_parentheses_valid

import java.util.*

/**
 * - Time complexity: O(N)
 * - Space complexity: O(N)
 */
class Solution {
    fun minAddToMakeValid(s: String): Int {
        // build a brackets stack that contain wrong-order brackets
        val charStack = Stack<Char>()
        // filter the matching nearby bracket "[]"
        // push the wrong-order brackets into stack
        s.forEach { c ->
            if (c == '(') {
                // push '('
                charStack.push(c)
            } else if (c == ')') {
                if (charStack.isNotEmpty() && charStack.peek() == '(') {
                    // matching nearby bracket "[]"
                    // pop '(' to match with ')'
                    charStack.pop()
                } else {
                    // push ')'
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
            if (c == '(') {
                openBrk++
            } else if (c == ')') {
                closeBrk++
            }
        }

        return openBrk + closeBrk
    }
}

fun main() {
    val result = Solution().minAddToMakeValid(
        "())"
    )
    println(result)
}