package y2024.q590_n_ary_tree_postorder_traversal

import y2024.utils.Node

class Solution {
    /**
     * - Time complexity: O(N)
     * - Space complexity: O(1)
     */
    fun postorder(root: Node?): List<Int> {
        if (root == null) return emptyList()

        val path = ArrayList<Int>()
        travel(root, path)
        path.add(root.`val`)

        return path
    }

    private fun travel(node: Node, path: MutableList<Int>) {
        // recursive travel to children nodes until reach leave
        node.children.forEach { child ->
            child?.let {
                travel(it, path)
            }
        }
        // no more child node
        // -> add node to path
        path.add(node.`val`)
    }
}

fun main() {
    val res = Solution().postorder(
        null
    )
    println(res)
}