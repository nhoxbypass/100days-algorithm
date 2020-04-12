package covid19.day10;

class Solution {
    public static void main(String[] args) {
    }

    static class MinStack {
        Node head = null;

        public MinStack() {

        }

        public void push(int x) {
            if (head == null) {
                head = new Node(x);
                head.currentMin = head;
            } else {
                Node newNode = new Node(x);

                if (x < head.currentMin.value) {
                    newNode.currentMin = newNode;
                } else {
                    newNode.currentMin = head.currentMin;
                }

                newNode.next = head;
                head = newNode;
            }
        }

        public void pop() {
            if (head == null)
                return;

            head = head.next;
        }

        public int top() {
            return head.value;
        }

        public int getMin() {
            return head.currentMin.value;
        }

        private static class Node {
            Node next = null;
            Node currentMin = null;
            int value;

            Node(int value) {
                this.value = value;
            }
        }
    }
}