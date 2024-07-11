package y2024.reverse_substrings_between_each_pair_of_parentheses_1190

class Solution {
    fun reverseParentheses(s: String): String {
        val charArray = s.toCharArray()
        val openIdxStack = ArrayDeque<Int>()
        for (i in charArray.indices) {
            // curr char
            val c = charArray[i]

            when (c) {
                '(' -> {
                    // add open bracket index into `openIdxStack`
                    openIdxStack.add(i)
                }

                ')' -> {
                    // loop from the prev open bracket -> curr close bracket
                    // to swap chars
                    val prevOpenIdx = openIdxStack.removeLast()
                    for (offset in 1..((i - prevOpenIdx) / 2)) {
                        swap(charArray, prevOpenIdx + offset, i - offset)
                    }
                    // clear processed open/close brackets
                    charArray[prevOpenIdx] = '_'
                    charArray[i] = '_'
                }

                else -> {
                    // normal char
                }
            }
        }

        // filter '_' and convert to result string
        return charArray.filterNot { it == '_' }.joinToString(separator = "")
    }

    private fun swap(charArray: CharArray, firstPos: Int, secondPos: Int) {
        val temp = charArray[firstPos]
        charArray[firstPos] = charArray[secondPos]
        charArray[secondPos] = temp
    }
}


fun main() {
    val res = Solution().reverseParentheses("(u(love)i)")
    println(res)
}