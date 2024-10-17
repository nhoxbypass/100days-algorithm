package y2024.q670_maximum_swap

class Solution {
    /**
     * - Time complexity: O(NLogN)
     * - Space complexity: O(N)
     */
    fun maximumSwap(num: Int): Int {
        // convert input number into list of digits
        val digits = integerToDigits(num)

        // sort the digits (ASC)
        val sortedIndices = digits.indices.sortedBy { digits[it] }.toMutableList()

        // check to swap with the first smaller digit (from the beginning of input number)
        for (idx in digits.indices) {
            val d = digits[idx]
            val currSortedIdx = sortedIndices.last() // last index is the biggest number
            if (idx == currSortedIdx) {
                // the current index is the biggest number
                // pop up
                sortedIndices.removeLast()
                continue
            }
            if (d < digits[currSortedIdx]) {
                // found the smaller number
                // swap
                digits[idx] = digits[currSortedIdx]
                digits[currSortedIdx] = d
                break
            }
            // remove the current index
            sortedIndices.remove(idx)
        }

        // convert back to Integer
        return digits.joinToString("").toInt()
    }

    private fun integerToDigits(number: Int): MutableList<Int> {
        val digits = mutableListOf<Int>()
        var n = number
        while (n > 0) {
            digits.add(n % 10)
            n /= 10
        }
        digits.reverse()
        return digits
    }
}

fun main() {
    val result = Solution().maximumSwap(
        9973
    )
    println(result)
}