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