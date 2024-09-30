package y2024.q1381_design_a_stack_with_increment_operation

/**
 * - Time complexity: O(1)
 * - Space complexity: O(N)
 */
class CustomStack(maxSize: Int) {

    private val stackData = IntArray(maxSize)
    private var currSize = 0

    fun push(x: Int) {
        if (currSize == stackData.size)
            return

        stackData[currSize++] = x
    }

    fun pop(): Int {
        if (currSize == 0) return -1

        currSize--
        return stackData[currSize]
    }

    fun increment(k: Int, `val`: Int) {
        var idx = 0
        while (idx < k && idx < stackData.size) {
            stackData[idx] += `val`
            idx++
        }
    }
}

class CustomStackOld(maxSize: Int) {

    private val maxSize = maxSize
    private val stackData = ArrayList<Int>(maxSize)

    fun push(x: Int) {
        if (stackData.size == maxSize)
            return

        stackData.add(x)
    }

    fun pop(): Int {
        return stackData.removeLastOrNull() ?: -1
    }

    fun increment(k: Int, `val`: Int) {
        var idx = 0
        while (idx < k && idx < stackData.size) {
            stackData[idx] = stackData[idx] + `val`
            idx++
        }
    }
}

fun main() {
    // Your CustomStack object will be instantiated and called as such:

    val stack = CustomStack(10)
    stack.push(1)
    var item = stack.pop()
    stack.increment(5, 3)
}