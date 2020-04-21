package covid19.day20_construct_binary_search_tree_from_preorder_traversal;

class Solution {
    public static void main(String[] args) {
        TreeNode root = bstFromPreorder(new int[]{4, 2});
    }

    public static TreeNode bstFromPreorder(int[] preorder) {
        if (preorder.length == 0)
            return null;

        return buildBST(preorder, 0, preorder.length - 1);
    }

    private static TreeNode buildBST(int[] preorder, int start, int end) {
        if (start > end)
            return null;

        int leftBound = start;
        TreeNode node = new TreeNode(preorder[start]);
        for (int i = start; i <= end; i++) {
            if (preorder[i] <= node.val)
                leftBound = i;
            else
                break;
        }

        node.left = buildBST(preorder, start + 1, leftBound);
        node.right = buildBST(preorder, leftBound + 1, end);

        return node;
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