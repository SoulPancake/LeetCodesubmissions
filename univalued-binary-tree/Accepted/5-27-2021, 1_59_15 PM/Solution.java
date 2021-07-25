// https://leetcode.com/problems/univalued-binary-tree

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
    public boolean isUnivalTree(TreeNode root) {
   
        
        return isUnival(root.left,root.val) && isUnival(root.right,root.val);
    }
    
    private boolean isUnival(TreeNode root,int val)
    {
        if(root==null)
            return true;
        if(root.val!=val)
            return false;
        
        return isUnival(root.left,val) && isUnival(root.right,val);
    }
}