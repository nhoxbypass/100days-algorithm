package covid19_1.odd_even_linked_list;

class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode res = oddEvenList(head);
    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode startEven = even;

        while (true) {
            ListNode nextNode = even.next;
            if (nextNode != null) {
                odd.next = nextNode;
                odd = nextNode;

                nextNode = nextNode.next;
                if (nextNode != null) {
                    even.next = nextNode;
                    even = nextNode;
                } else {
                    break;
                }
            } else {
                break;
            }
        }

        odd.next = startEven;
        even.next = null;

        return head;
    }

    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}