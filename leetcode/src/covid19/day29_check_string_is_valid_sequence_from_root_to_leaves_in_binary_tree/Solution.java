package covid19.day29_check_string_is_valid_sequence_from_root_to_leaves_in_binary_tree;

class Solution {
    public static void main(String[] args) {
    }

    public boolean isValidSequence(TreeNode root, int[] arr) {
        return dfs(root, 0, arr);
    }

    public boolean dfs(TreeNode curNode, int currPos, int[] arr) {
        if (curNode.val == arr[currPos]) {
            if (currPos >= arr.length - 1) {
                // Reach the end
                return isLeave(curNode);
            }

            // Continue
            boolean res = false;
            if (curNode.left != null) {
                res = dfs(curNode.left, currPos + 1, arr);
            }

            if (!res && curNode.right != null) {
                res = dfs(curNode.right, currPos + 1, arr);
            }
            return res;
        } else {
            // Travel back
            return false;
        }
    }

    private boolean isLeave(TreeNode curNode) {
        return curNode.left == null && curNode.right == null;
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