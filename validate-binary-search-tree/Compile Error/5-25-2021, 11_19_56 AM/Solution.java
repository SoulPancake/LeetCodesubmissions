// https://leetcode.com/problems/validate-binary-search-tree

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
  
    public boolean isValidBST(TreeNode root) {
     if(root == null){
            return true;
        }
         boolean res = true;
        
        res = isValidBST(root.left);
        if(!res){
            return res;
        }
        
        if(pre!=null&&pre.val>=root.val){
            return false;
        }else{
            pre = root;
        } 
        
        res = isValidBST(root.right);
        if(!res){
            return res;
        }
        
        return res;
        
    }

}