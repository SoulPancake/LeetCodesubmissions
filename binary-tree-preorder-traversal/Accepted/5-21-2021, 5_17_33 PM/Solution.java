// https://leetcode.com/problems/binary-tree-preorder-traversal

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
     List<Integer> l;
    public List<Integer> preorderTraversal(TreeNode root) {
        l=new ArrayList<>();
        
        rec(root);
        
        return l;
    }
    public void rec(TreeNode root)
    {
        if(root==null)
            return;
        l.add(root.val);
        rec(root.left);
        
        rec(root.right);
    }
}