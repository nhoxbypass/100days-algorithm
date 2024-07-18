package y2024.q2096_step_by_step_directions_from_a_binary_tree_node_to_another

import y2024.utils.TreeNode
import y2024.utils.buildTreeFromBFS

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