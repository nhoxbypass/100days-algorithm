package y2024.q641_design_circular_deque

/**
 * - Time complexity: O(LogN)
 * - Space complexity: O(N)
 */
class MyCircularDeque(k: Int) {
    private val maxSize = k
    private var currSize = 0
    private var front: Node? = null
    private var rear: Node? = null

    fun insertFront(value: Int): Boolean {
        if (isFull()) return false

        val node = Node(value)
        if (currSize == 0) {
            // first node
            front = node
            rear = node
        } else {
            // link with front node
            front?.let {
                it.prev = node
                node.next = it
            }
            front = node
        }
        currSize++
        return true
    }

    fun insertLast(value: Int): Boolean {
        if (isFull()) return false

        val node = Node(value)
        if (currSize == 0) {
            // first node
            front = node
            rear = node
        } else {
            // link with rear node
            rear?.let {
                it.next = node
                node.prev = it
            }
            rear = node
        }
        currSize++
        return true
    }

    fun deleteFront(): Boolean {
        if (front == null) return false

        // mark new front note (if exist)
        val nextNode = front!!.next
        if (nextNode != null) {
            nextNode.prev = null
            front = nextNode
        } else {
            front = null
        }
        currSize--
        if (currSize == 0) {
            // empty queue
            front = null
            rear = null
        }
        return true
    }

    fun deleteLast(): Boolean {
        if (rear == null) return false

        // mark new rear note (if exist)
        val prevNode = rear!!.prev
        if (prevNode != null) {
            prevNode.next = null
            rear = prevNode
        } else {
            rear = null
        }
        currSize--
        if (currSize == 0) {
            // empty queue
            front = null
            rear = null
        }
        return true
    }

    fun getFront(): Int {
        return front?.value ?: -1
    }

    fun getRear(): Int {
        return rear?.value ?: -1
    }

    fun isEmpty(): Boolean {
        return currSize == 0
    }

    fun isFull(): Boolean {
        return currSize == maxSize
    }

    private class Node(val value: Int) {
        var prev: Node? = null
        var next: Node? = null
    }
}

fun main() {
    // Your MyCircularDeque object will be instantiated and called as such:

    val obj = MyCircularDeque(5)
    var param_1 = obj.insertFront(1)
    var param_2 = obj.insertLast(2)
    var param_3 = obj.deleteFront()
    var param_4 = obj.deleteLast()
    var param_5 = obj.getFront()
    var param_6 = obj.getRear()
    var param_7 = obj.isEmpty()
    var param_8 = obj.isFull()
}