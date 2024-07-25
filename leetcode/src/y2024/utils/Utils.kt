package y2024.utils

import java.util.*

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    override fun toString(): String {
        return "TreeNode(`val`=$`val`)"
    }
}

fun buildTreeFromBFS(nodes: List<Int?>): TreeNode? {
    if (nodes.isEmpty() || nodes[0] == null) return null

    val root = TreeNode(nodes[0]!!)
    val queue: Queue<TreeNode> = LinkedList<TreeNode>()
    queue.add(root)

    var index = 1
    while (index < nodes.size && !queue.isEmpty()) {
        val node = queue.poll()
        val leftValue = nodes[index++]
        if (leftValue != null) {
            node.left = TreeNode(leftValue)
            queue.offer(node.left)
        }
        if (index < nodes.size) {
            val rightValue = nodes[index++]
            if (rightValue != null) {
                node.right = TreeNode(rightValue)
                queue.offer(node.right)
            }
        }
    }

    return root
}

/**
 * Quick Sort
 */
fun quickSort(nums: IntArray, low: Int, high: Int) {
    if (low >= high)
        return

    // partition into 2 part
    val pivotIdx = partition(nums, low, high)

    // recursive quick sort with lower part
    quickSort(nums, low, pivotIdx - 1)
    // recursive quick sort with higher part
    quickSort(nums, pivotIdx + 1, high)
}

private fun partition(nums: IntArray, low: Int, high: Int): Int {
    val pivot = nums[high]

    // do the partition
    var lowIdx = low
    for (i in low..high) {
        if (nums[i] < pivot) {
            // swap smaller number to the left of pivot
            swap(nums, lowIdx, i)
            lowIdx++
        } else {
            // do nothing, keep the position of bigger number
        }
    }

    // swap pivot to the middle position (which split the array into 2 part)
    swap(nums, lowIdx, high)

    // return the index of pivot item
    return lowIdx
}

private fun swap(nums: IntArray, firstIdx: Int, secondIdx: Int) {
    if (firstIdx != secondIdx) {
        nums[firstIdx] = nums[secondIdx].also { nums[secondIdx] = nums[firstIdx] }
    }
}