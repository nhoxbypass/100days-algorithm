package y2024.q145_binary_tree_postorder_traversal

import y2024.utils.TreeNode
import y2024.utils.buildTreeFromBFS

class Solution {
    /**
     * - Time complexity: O(N)
     * - Space complexity: O(1)
     */
    fun postorderTraversal(root: TreeNode?): List<Int> {
        if (root == null) return emptyList()

        val path = ArrayList<Int>()
        root.left?.let {
            travel(it, path)
        }
        root.right?.let {
            travel(it, path)
        }

        path.add(root.`val`)

        return path
    }

    private fun travel(node: TreeNode, path: MutableList<Int>) {
        // recursive travel LEFT node until reach leave
        node.left?.let {
            travel(it, path)
        }
        // recursive travel RIGHT node until reach leave
        node.right?.let {
            travel(it, path)
        }
        // no more child node
        // -> add node to path
        path.add(node.`val`)
    }
}

fun main() {
    val res = Solution().postorderTraversal(
        buildTreeFromBFS(listOf(1, null, 2, 3))
    )
    println(res)
}