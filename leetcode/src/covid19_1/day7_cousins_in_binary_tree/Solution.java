package covid19_1.day7_cousins_in_binary_tree;

class Solution {
    public static void main(String[] args) {
        /*TreeNode node1 = new TreeNode(2, new TreeNode(4), null);
        TreeNode node2 = new TreeNode(3);
        TreeNode root = new TreeNode(1, node1, node2);*/

        TreeNode node1 = new TreeNode(2, new TreeNode(4), null);
        TreeNode node2 = new TreeNode(2,
                new TreeNode(8,
                        new TreeNode(9), null),
                new TreeNode(3,
                        new TreeNode(4,
                                new TreeNode(6), null), null));
        TreeNode root = new TreeNode(1, node1, node2);

        boolean res = isCousins(root, 9, 4);
        System.out.println(res);
    }

    static int currDepth = 0;

    public static boolean isCousins(TreeNode root, int x, int y) {
        TreeNode xParent = parentSearch(root, x, 0);
        int xDepth = currDepth;
        currDepth = 0;

        TreeNode yParent = parentSearch(root, y, 0);
        int yDepth = currDepth;

        if (xDepth == yDepth) {
            return xParent != yParent;
        }
        return false;
    }

    public static TreeNode parentSearch(TreeNode node, int val, int depth) {
        if (node == null)
            return null;

        if ((node.left != null && node.left.val == val) || (node.right != null && node.right.val == val)) {
            currDepth = depth + 1;
            return node;
        } else {
            TreeNode res = parentSearch(node.left, val, depth + 1);
            if (currDepth == 0) {
                res = parentSearch(node.right, val, depth + 1);
            }
            return res;
        }
    }

    /**
     * Definition for a binary tree node.
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}