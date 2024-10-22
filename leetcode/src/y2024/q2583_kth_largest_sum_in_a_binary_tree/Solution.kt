package y2024.q2583_kth_largest_sum_in_a_binary_tree

import y2024.utils.TreeNode
import y2024.utils.buildTreeFromBFS
import java.util.*

class Solution {
    /**
     * - Time complexity: O(NLogN)
     * - Space complexity: O(N)
     */
    fun kthLargestLevelSum(root: TreeNode?, k: Int): Long {
        // LinkedList<> to store the "waiting queue" of nodes that need to be sum
        val waitingQueue = LinkedList<TreeNode>()

        // PQ to store sum by level.
        // - Each item in PQ is the sum of N-th level
        // - Use PQ (instead of List<>) to support auto-sorted by natural order
        val sortedSum = PriorityQueue<Long>(compareByDescending { it })

        // Add the ROOT node to the "waiting queue"
        waitingQueue.offer(root)

        // Loop until the "waiting queue" is EMPTY
        while (waitingQueue.isNotEmpty()) {
            // Travel through all nodes in the "waiting queue" to calculate the sum
            var sum = 0L
            for (i in 0 until waitingQueue.size) {
                val node = waitingQueue.poll()!!
                // Increase the sum of current level
                sum += node.`val`
                // Add left/right children of this node to the "waiting queue"
                node.left?.let { waitingQueue.offer(it) }
                node.right?.let { waitingQueue.offer(it) }
            }
            // Add calculated sum (of current level) into PQ
            sortedSum.offer(sum)
            // Continue with the new nodes in the "waiting queue"
        }

        // Repeat to remove (k-1) largest sums
        repeat(k - 1) { sortedSum.poll() }
        // Poll the K-th largest sum as the final result
        return sortedSum.poll() ?: -1
    }
}

fun main() {
    val result = Solution().kthLargestLevelSum(
        buildTreeFromBFS(listOf(5, 8, 9, 2, 1, 3, 7, 4, 6)),
        2
    )
    println(result)
}