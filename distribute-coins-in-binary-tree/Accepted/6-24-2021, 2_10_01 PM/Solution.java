// https://leetcode.com/problems/distribute-coins-in-binary-tree

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
    int numberOfMoves;
    public int distributeCoins(TreeNode root) {
        if(root==null)return 0;
        numberOfMoves=0;
        helper(root);
        return numberOfMoves;
        
    }
    
    private int helper(TreeNode root)
    {
        if(root==null)return 0;
        
        int left=helper(root.left);
        int right=helper(root.right);
        
        numberOfMoves+=Math.abs(left)+Math.abs(right);
        return root.val+left+right-1;
    }
}