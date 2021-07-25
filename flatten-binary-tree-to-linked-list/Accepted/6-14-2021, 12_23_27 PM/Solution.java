// https://leetcode.com/problems/flatten-binary-tree-to-linked-list

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
    public void flatten(TreeNode root) {
     helper(root);   
    }
    
    public TreeNode helper(TreeNode node){
        if(node==null){
            return null;
        }
        
        TreeNode left = helper(node.left);
        TreeNode right = helper(node.right);
        
        if(left==null && right==null){
            return node;
        }else if(left==null && right!=null){
            return right;
        }else if(left!=null && right==null){
            node.right = node.left;
            node.left = null;
            return left;
        }else{
            TreeNode temp = node.right;
            node.right = node.left;
            left.right = temp;
            node.left = null;
            return right;
        }
    }
}