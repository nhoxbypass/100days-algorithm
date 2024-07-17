package y2024.q1598_crawler_log_folder

class Solution {
    private val BACK = "../"
    private val STAY = "./"

    fun minOperations(logs: Array<String>): Int {
        var depth = 0
        logs.forEach { operation ->
            when (operation) {
                BACK -> {
                    // move back to parent folder
                    depth--
                    depth = depth.coerceAtLeast(0)
                }

                STAY -> {
                    // stay current folder
                }

                else -> {
                    // navigate to folder X
                    depth++
                }
            }
        }
        return depth
    }
}


fun main() {
    val logs = arrayOf("d1/", "d2/", "../", "d21/", "./")
    val res = Solution().minOperations(logs)
    println(res)
}