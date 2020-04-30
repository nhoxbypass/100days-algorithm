package covid19.day28_binary_tree_maximum_path_sum;

class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        //root.left = new TreeNode(2);
        //root.right = new TreeNode(3);

        int res = maxPathSum(root);
        System.out.println(res);
    }

    static int maxSum = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {
        if (root == null)
            return 0;

        dfs(root);
        return maxSum;
    }

    static int dfs(TreeNode node) {
        int lSum = 0;
        if (node.left != null) {
            lSum = dfs(node.left);
        }
        // Only take the left sum when it's not negative (because we need MAX)
        if (lSum < 0)
            lSum = 0;

        int rSum = 0;
        if (node.right != null) {
            rSum = dfs(node.right);
        }
        // Only take the right sum when it's not negative (because we need MAX)
        if (rSum < 0)
            rSum = 0;

        int total = node.val + lSum + rSum;
        if (total > maxSum) {
            maxSum = total;
        }

        // Then return SUM of current node + max child (left or right)
        // or only current node if left & right is negative
        return node.val + Math.max(lSum, rSum);
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