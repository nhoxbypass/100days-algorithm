package y2024.q2641_cousins_in_binary_tree_ii

import y2024.utils.TreeNode
import y2024.utils.buildTreeFromBFS
import java.util.*

class Solution {
    /**
     * - Time complexity: O(N)
     * - Space complexity: O(N)
     */
    fun replaceValueInTree(root: TreeNode?): TreeNode? {
        if (root == null)
            return root

        // LinkedList<> to store the "waiting queue" of nodes that need to be sum
        val waitingQueue = LinkedList<TreeNode?>()

        // Sum of the ROOT node is always 0
        root.`val` = 0

        // Add the ROOT node to the "waiting queue"
        waitingQueue.offer(root)

        // Loop until the "waiting queue" is EMPTY
        while (waitingQueue.isNotEmpty()) {
            // Loop to calculate the sum of all children nodes of this level
            val currSize = waitingQueue.size
            var totalSum = 0
            for (i in 0 until currSize) {
                val node = waitingQueue[i]
                totalSum += ((node?.left?.`val` ?: 0) + (node?.right?.`val` ?: 0))
            }
            // Loop to update the cousin sum
            for (i in 0 until currSize) {
                val node = waitingQueue.poll()
                val cousinSum = totalSum - ((node?.left?.`val` ?: 0) + (node?.right?.`val` ?: 0))
                node?.left?.let {
                    // Update value based on cousin sum
                    it.`val` = cousinSum
                    // Add children of this node to the "waiting queue"
                    waitingQueue.offer(it)
                }
                node?.right?.let {
                    // Update value based on cousin sum
                    it.`val` = cousinSum
                    // Add children of this node to the "waiting queue"
                    waitingQueue.offer(it)
                }
            }
            // Continue with the new nodes in the "waiting queue"
        }

        return root
    }

    fun replaceValueInTreeOld(root: TreeNode?): TreeNode? {
        if (root == null)
            return root

        // LinkedList<> to store the "waiting queue" of nodes that need to be sum
        val waitingQueue = LinkedList<TreeNode?>()

        // Sum of the ROOT node is always 0
        root.`val` = 0

        // Add the ROOT.left / ROOT.right node to the "waiting queue"
        waitingQueue.offer(root.left)
        waitingQueue.offer(root.right)

        // Loop until the "waiting queue" is EMPTY
        while (waitingQueue.isNotEmpty()) {
            // Travel through all nodes in the "waiting queue" to calculate the sum
            val currSize = waitingQueue.size
            var totalSum = 0
            for (i in 0 until currSize) {
                totalSum += (waitingQueue[i]?.`val` ?: 0)
            }
            for (i in 0 until currSize / 2) {
                val lNode = waitingQueue.poll()
                val rNode = waitingQueue.poll()
                val cousinSum = totalSum - ((lNode?.`val` ?: 0) + (rNode?.`val` ?: 0))
                lNode?.let {
                    // Update value based on sum
                    it.`val` = cousinSum
                    // Add left/right children of this node to the "waiting queue"
                    waitingQueue.offer(it.left)
                    waitingQueue.offer(it.right)
                }
                rNode?.let {
                    // Update value based on sum
                    it.`val` = cousinSum
                    // Add left/right children of this node to the "waiting queue"
                    waitingQueue.offer(it.left)
                    waitingQueue.offer(it.right)
                }
            }
            // Continue with the new nodes in the "waiting queue"
        }

        return root
    }
}

fun main() {
    val result = Solution().replaceValueInTree(
        buildTreeFromBFS(listOf(5, 4, 9, 1, 10, null, 7)),
    )
    println(result)
}