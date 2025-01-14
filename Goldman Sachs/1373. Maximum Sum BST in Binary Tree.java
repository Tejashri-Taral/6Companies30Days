/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    int result;

    public int[] helper(TreeNode curr) {
        if (curr == null) {
            return new int[] { Integer.MAX_VALUE, Integer.MIN_VALUE, 0 };
        }

        int left[] = helper(curr.left);
        int right[] = helper(curr.right);

        // No BST Case
        if (left[1] >= curr.val || right[0] <= curr.val) {
            return new int[] { Integer.MIN_VALUE, Integer.MAX_VALUE, 0 };
        }

        int sum = left[2] + curr.val + right[2];

        result = Math.max(sum, result);

        return new int[] { Math.min(curr.val, left[0]), Math.max(curr.val, right[1]), sum };
    }

    public int maxSumBST(TreeNode root) {
        result = Integer.MIN_VALUE;

        if (root == null) {
            return 0;
        } else {
            helper(root);
            return result < 0 ? 0 : result;
        }
    }
}
