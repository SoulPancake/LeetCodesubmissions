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
        if(root==null)return true;
        int val=root.val;
        return isUnival(root.left,val)&&isUnival(root.right,val);
    }
    
    private boolean isUnival(TreeNode root,int val)
    {
        if(root==null)return true;
        
        boolean isValid=(root.val==val);
        
        return isValid&&isUnival(root.left,val)&&isUnival(root.right,val);
    }
    }
