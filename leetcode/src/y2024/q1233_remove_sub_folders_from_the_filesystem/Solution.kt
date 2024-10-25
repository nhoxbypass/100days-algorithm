package y2024.q1233_remove_sub_folders_from_the_filesystem

class Solution {
    /**
     * - Time complexity: O(N * Max(M))
     * - Space complexity: O(N)
     */
    fun removeSubfolders(folder: Array<String>): List<String> {
        if (folder.isEmpty())
            return emptyList()

        val validFolders = ArrayList<String>()
        for (i in 0..folder.size - 2) {
            val f = folder[i]
            if (f.isEmpty()) {
                continue
            }
            var valid = true
            for (j in i + 1..folder.size - 1) {
                val fj = folder[j]
                if (fj.isEmpty()) {
                    // Folder at j idx is removed
                    // Continue to check
                    continue
                } else if (f.startsWith("${fj}/")) {
                    // F is an INVALID folder
                    // break
                    valid = false
                    break
                } else if (fj.startsWith("$f/")) {
                    folder[j] = ""
                } else {
                    // F may be a valid folder
                    // Continue to check
                }
            }
            if (valid) {
                validFolders.add(f)
            }
        }

        // Check the last Folder
        val lastFolder = folder.lastOrNull()
        if (!lastFolder.isNullOrEmpty()) {
            validFolders.add(lastFolder)
        }

        return validFolders
    }
}

fun main() {
    val result = Solution().removeSubfolders(
        arrayOf(
            "/aa/ab/ac/ad",
            "/aa/aq/ay",
            "/bf/bv/cd/ch/cj",
            "/bf/bg",
            "/aa/aq/ar",
            "/bf",
            "/aa/ab/aj/an/ao",
            "/aa/aq/ay/az",
            "/aa/aq/ay/bc",
            "/bf/bg/bh/bi/bj",
            "/bf/bv/bw/ca/cc",
            "/bf/bg/bh/bl"
        )
    )
    println(result)
}