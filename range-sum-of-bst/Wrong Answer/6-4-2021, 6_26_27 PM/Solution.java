// https://leetcode.com/problems/range-sum-of-bst

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
    
    public int rangeSumBST(TreeNode root, int low, int high) {
       int sum=0;
        helper(root,low,high,sum);
        
        return sum;
    }
    
    private void helper(TreeNode root,int low,int high,int sum)
    {
        if(root==null)
            return;
        
        if(root.val>=low && root.val<=high) sum+=root.val;
        helper(root.left,low,high,sum);
        helper(root.right,low,high,sum);
    }
}