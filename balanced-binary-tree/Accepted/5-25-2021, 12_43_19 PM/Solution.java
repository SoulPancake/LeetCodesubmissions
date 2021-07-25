// https://leetcode.com/problems/balanced-binary-tree

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
    boolean is;
    public boolean isBalanced(TreeNode root) {
        is=true;
        balancedHeight(root);
        return is;
    }
    
    private int balancedHeight(TreeNode root)
    {
        if(is==false) return 0;
        if(root==null) return 0;
        
        int h1=balancedHeight(root.left);
        int h2=balancedHeight(root.right);
        
        if(Math.abs(h1-h2)>1)
            {is=false;return -1;}
        
        return Math.max(h1,h2)+1;
        
    }
}