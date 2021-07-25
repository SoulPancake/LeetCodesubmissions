// https://leetcode.com/problems/binary-tree-tilt

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
    int tilt;
    public int findTilt(TreeNode root) {
        if(root==null)
            return 0;
        tilt=0;
       findSum(root);
        return tilt;
        
    }
    private int findSum(TreeNode root)
    {
        if(root==null) return 0;
        int left=findSum(root.left);
        int right=findSum(root.right);
        tilt+=Math.abs(left-right);
        return left+right+root.val;
    }
}