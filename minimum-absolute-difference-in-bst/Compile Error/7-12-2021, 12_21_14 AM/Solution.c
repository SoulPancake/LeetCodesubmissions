// https://leetcode.com/problems/minimum-absolute-difference-in-bst

class Solution {
    private int prev = -1;
    private int minDiff = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        helper(root);
        return minDiff;
    }
    private void helper(TreeNode root)
    {
        if(root == null) return;
        helper(root.left);
        if(prev != -1)
        {
            int diff = Math.abs(root.val-prev);
            minDiff = Math.min(minDiff, diff);
        }
        prev = root.val;
        helper(root.right);
    }
}