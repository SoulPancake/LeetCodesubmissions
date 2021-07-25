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
         TreeNode temp;
        if(root==null || (root.left==null && root.right==null))
            return ;
        flatten(root.left);
        flatten(root.right);
        if(root.left==null)
            return ;
        temp=root.left;
        while(temp.right!=null)
            temp=temp.right;
        temp.right=root.right;
        root.right=root.left;
        root.left=null;
    }
}