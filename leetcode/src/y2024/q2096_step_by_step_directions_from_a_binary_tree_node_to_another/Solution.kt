package y2024.q2096_step_by_step_directions_from_a_binary_tree_node_to_another

import java.util.*

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
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

class Solution {
    fun getDirections(root: TreeNode?, startValue: Int, destValue: Int): String {
        traverse(root, startValue, destValue)
        return finalPath.removePrefix("S").removeSuffix("D")
    }

    private var finalPath = ""

    private fun traverse(node: TreeNode?, startValue: Int, destValue: Int): Pair<String, String> {
        if (node == null)
            return Pair("", "")
        if (finalPath.isNotEmpty())
            return Pair("", "")

        var pathFromStart = ""
        if (node.`val` == startValue)
            pathFromStart = "S"
        if (node.`val` == startValue)
            pathFromStart = "S"

        var pathToDest = ""
        if (node.`val` == destValue)
            pathToDest = "D"
        if (node.left?.`val` == destValue)
            pathToDest = "L"
        if (node.right?.`val` == destValue)
            pathToDest = "R"

        if (pathFromStart.isNotEmpty() && pathToDest.isNotEmpty()) {
            finalPath = pathFromStart + pathToDest
            return Pair(pathFromStart, pathToDest)
        }

        val leftPath = traverse(node.left, startValue, destValue)
        if (finalPath.isNotEmpty()) {
            return leftPath
        }
        if (leftPath.first.isNotEmpty()) {
            pathFromStart = leftPath.first + "U"
        }
        if (leftPath.second.isNotEmpty()) {
            pathToDest = "L" + leftPath.second
        }
        if (pathFromStart.isNotEmpty() && pathToDest.isNotEmpty()) {
            finalPath = pathFromStart + pathToDest
            return Pair(pathFromStart, pathToDest)
        }

        val rightPath = traverse(node.right, startValue, destValue)
        if (finalPath.isNotEmpty()) {
            return rightPath
        }
        if (rightPath.first.isNotEmpty()) {
            pathFromStart = rightPath.first + "U"
        }
        if (rightPath.second.isNotEmpty()) {
            pathToDest = "R" + rightPath.second
        }
        if (pathFromStart.isNotEmpty() && pathToDest.isNotEmpty()) {
            finalPath = pathFromStart + pathToDest
            return Pair(pathFromStart, pathToDest)
        }

        return Pair(pathFromStart, pathToDest)
    }
}

fun main() {
    val root = buildTreeFromBFS(listOf(5, 1, 2, 3, null, 6, 4))
    val res = Solution().getDirections(root, 3, 6)
    println(res)
}