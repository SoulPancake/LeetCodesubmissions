// https://leetcode.com/problems/construct-string-from-binary-tree

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
    String s;
    public String tree2str(TreeNode root) {
        s=new String();
        preOrder(root);
        return s;
    }
    private void preOrder(TreeNode root)
    {
        if(root==null)
            return;
        
        
        s.append(root.val);
        preOrder(root.left);
        preOrder(root.right);
        return;
    }
}