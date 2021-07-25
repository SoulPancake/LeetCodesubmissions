// https://leetcode.com/problems/binary-tree-maximum-path-sum

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxPathSum(TreeNode root) {
        if(root==null)return 0;
        int result=0;
        int left=maxPathSum(root.left);
        int right=maxPathSum(root.right);
        int ms=Math.max(Math.max(left,right)+root.val,root.val);
        int m2=Math.max(ms,left+right+root.val);
        return Math.max(result,m2);
    }
}