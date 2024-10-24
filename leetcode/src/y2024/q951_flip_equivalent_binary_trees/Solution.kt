package y2024.q951_flip_equivalent_binary_trees

import y2024.utils.TreeNode
import y2024.utils.buildTreeFromBFS
import java.util.*


class Solution {
    /**
     * - Time complexity: O(N)
     * - Space complexity: O(N)
     */
    fun flipEquiv(root1: TreeNode?, root2: TreeNode?): Boolean {
        // Compare the 2 root nodes
        if (root1 == null || root2 == null)
            return root1 == null && root2 == null
        if (root1.`val` != root2.`val`)
            return false

        // Init 2 `LinkedList<>` to store the "waiting queue" of nodes from each tree
        val waitingQueue1 = LinkedList<TreeNode>()
        val waitingQueue2 = LinkedList<TreeNode>()

        // Add the ROOT nodes to 2 separate "waiting queue"
        waitingQueue1.offer(root1)
        waitingQueue2.offer(root2)

        // Loop until the "waiting queue" is EMPTY
        while (waitingQueue1.isNotEmpty() && waitingQueue2.isNotEmpty()) {
            // Loop to check same/swappable children nodes of this level
            for (i in 0 until waitingQueue1.size) {
                val node1 = waitingQueue1.poll()
                val node2 = waitingQueue2.poll()
                if (hasSameChildren(node1, node2)) {
                    // If the node1 and node2 have same children values
                    // Keep their position
                } else if (hasSymmetricChildren(node1, node2)) {
                    // If the node1 and node2 has symmetrical (swappable) children values
                    // Swap them
                    val tmp = node1.left
                    node1.left = node1.right
                    node1.right = tmp
                } else {
                    // INVALID
                    return false
                }

                // Add children nodes into the "waiting queue"
                node1.left?.let { waitingQueue1.offer(it) }
                node1.right?.let { waitingQueue1.offer(it) }
                node2.left?.let { waitingQueue2.offer(it) }
                node2.right?.let { waitingQueue2.offer(it) }
            }
            // Continue with the new nodes in the "waiting queue"
        }

        return true
    }

    private fun hasSameChildren(node1: TreeNode?, node2: TreeNode?): Boolean {
        if (node1 == null || node2 == null) {
            return node1 == null && node2 == null
        }
        return node1.left?.`val` == node2.left?.`val`
                && node1.right?.`val` == node2.right?.`val`
    }

    private fun hasSymmetricChildren(node1: TreeNode?, node2: TreeNode?): Boolean {
        if (node1 == null || node2 == null) {
            return node1 == null && node2 == null
        }
        return node1.left?.`val` == node2.right?.`val`
                && node1.right?.`val` == node2.left?.`val`
    }
}

fun main() {
    val result = Solution().flipEquiv(
        buildTreeFromBFS(listOf(1, 2, 3, 4, 5, 6, null, null, null, 7, 8)),
        buildTreeFromBFS(listOf(99, 3, 2, null, 6, 4, 5, null, null, null, null, 8, 7))
    )
    println(result)
}