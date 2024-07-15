package y2024.create_binary_tree_from_descriptions_2196

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun createBinaryTree(descriptions: Array<IntArray>): TreeNode? {
        val rootMap = hashMapOf<Int, TreeNode>()
        val nodeMap = hashMapOf<Int, TreeNode>()
        descriptions.forEach { description ->
            // prepare data
            val parent = description[0]
            val child = description[1]
            val isLeft = description[2] == 1
            // get parent node (if exist)
            val parentNode = nodeMap.getOrPut(parent) {
                TreeNode(parent).also {
                    // put to root map when found new parent node
                    rootMap[parent] = it
                }
            }
            // get child node (if exist)
            val childNode = nodeMap.getOrPut(child) {
                TreeNode(child)
            }
            // link the parent-child node
            if (isLeft) {
                parentNode.left = childNode
            } else {
                parentNode.right = childNode
            }
            // find the root
            // if a node is child node, it cannot be root -> remove
            if (rootMap.contains(child)) {
                rootMap.remove(child)
            }
        }
        // return the last root
        return rootMap.values.first()
    }
}


fun main() {
    val customers = arrayOf(intArrayOf(20, 15, 1), intArrayOf(20, 17, 0), intArrayOf(50, 20, 1), intArrayOf(50, 80, 0), intArrayOf(80, 19, 1))
    val res = Solution().createBinaryTree(customers)
    println(res)
}