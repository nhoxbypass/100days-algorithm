package y2024.q725_split_linked_list_in_parts

import y2024.utils.ListNode
import y2024.utils.buildSingleLinkedList

class Solution {
    /**
     * - Time complexity: O(N)
     * - Space complexity: O(K)
     */
    fun splitListToParts(head: ListNode?, k: Int): Array<ListNode?> {
        val result = Array<ListNode?>(k) { null }

        if (head == null) return result

        // calculate size, items per part
        val size = getLinkedListSize(head)
        val itemPerPart = size / k
        var remainingItems = size % k

        // split into parts
        var currIdx = 0
        var currNode = head
        while (currIdx < k && currNode != null) {
            if (itemPerPart == 0 && remainingItems == 0) break
            var currCount = itemPerPart
            if (remainingItems > 0) {
                currCount++
                remainingItems--
            }
            var currSubNode: ListNode? = null
            repeat(currCount) {
                val subNode = ListNode(currNode!!.`val`)
                if (currSubNode == null) {
                    // first node
                    // add to result list
                    result[currIdx] = subNode
                } else {
                    // attach to prev node
                    currSubNode!!.next = subNode
                }
                currSubNode = subNode
                // move to next node
                currNode = currNode!!.next
            }
            currIdx++
        }
        return result
    }

    private fun getLinkedListSize(head: ListNode?): Int {
        var size = 0
        var node = head
        while (node != null) {
            size++
            node = node.next
        }
        return size
    }
}

fun main() {
    val res = Solution().splitListToParts(
        buildSingleLinkedList(listOf(1, 2, 3)),
        5
    )
    println(res)
}