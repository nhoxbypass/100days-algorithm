package y2024.q1530_number_of_good_leaf_nodes_pairs

import y2024.utils.TreeNode
import y2024.utils.buildTreeFromBFS

class Solution {
    fun countPairs(root: TreeNode?, distance: Int): Int {
        if (root == null) return 0

        traverse(root, distance)

        return goodLeafCount
    }

    // count good leaf
    private var goodLeafCount = 0

    /**
     * Travel until throughout current [node] to find distance to all leaves
     */
    private fun traverse(node: TreeNode, distance: Int): MutableList<Int> {
        if (node.left == null && node.right == null) {
            // leaf node
            // add new distance to list (distance=0)
            return arrayListOf(0)
        }

        // travel to find distance to leaf node
        val distanceToLeaf = arrayListOf<Int>()
        val distanceToLeafL = node.left?.let {
            traverse(it, distance)
        }
        if (distanceToLeafL != null) {
            // increase distance to all leaves to +1
            increaseDistance(distanceToLeafL)
            // add to overall distance list to passing up
            distanceToLeaf.addAll(distanceToLeafL)
        }
        val distanceToLeafR = node.right?.let {
            traverse(it, distance)
        }
        if (distanceToLeafR != null) {
            // increase distance to all leaves to +1
            increaseDistance(distanceToLeafR)
            // add to overall distance list to passing up
            distanceToLeaf.addAll(distanceToLeafR)
        }

        // find good leaf from distance list
        if (distanceToLeafL != null && distanceToLeafR != null) {
            distanceToLeafL.forEach { l ->
                if (l < distance) {
                    distanceToLeafR.forEach { r ->
                        if (l + r <= distance) {
                            goodLeafCount++
                        }
                    }
                }
            }
        }

        return distanceToLeaf
    }

    private fun increaseDistance(distanceList: MutableList<Int>) {
        distanceList.forEachIndexed { index, value ->
            distanceList[index] = value + 1
        }
    }
}

fun main() {
    val root = buildTreeFromBFS(listOf(1, 2, 3, null, 4))
    val res = Solution().countPairs(root, 3)
    println(res)
}