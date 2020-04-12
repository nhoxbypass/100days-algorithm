package covid19.day11;

class Solution {
    public static void main(String[] args) {
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        Diameter diameter = new Diameter();
        dfs(root, 0, diameter);
        return diameter.val;
    }

    static int dfs(TreeNode node, int depth, Diameter diameter) {
        int left = 0;
        if (node.left != null) {
            left = dfs(node.left, 1, diameter);
        }

        int right = 0;
        if (node.right != null) {
            right = dfs(node.right, 1, diameter);
        }

        if (left + right > diameter.val) {
            diameter.val = left + right;
        }

        return depth + Math.max(left, right);
    }

    static class Diameter {
        int val = 0;
    }

    /**
     * Definition for a binary tree node.
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}