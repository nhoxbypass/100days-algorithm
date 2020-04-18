package covid19.day8_middle_of_linked_list;

class Solution {
    public static void main(String[] args) {
    }

    /**
     * Definition for singly-linked list.
     */

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode middleNode(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode res = head;
        while (head != null && head.next != null) {
            res = res.next;
            head = head.next.next;
        }
        return res;
    }
}