// https://leetcode.com/problems/binary-tree-pruning

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
    public TreeNode pruneTree(TreeNode root) {
        if(root==null) return null;
        
        containsOne(root);
         if(!containsOne(root))  root = null;
        
        return root;
    }
    
    public boolean containsOne(TreeNode root)
    {
        if(root==null)return false;
        boolean leftContains=containsOne(root.left);
        boolean rightContains=containsOne(root.right);
        
        if(!leftContains)
            root.left=null;
        if(!rightContains)
            root.right=null;
        
        return root.val==1 || leftContains || rightContains;
        //if the value is 1 or the left or right contains 1 then this subtree is safe
        //Otherwise we have to remove that subtree from the root by the lines #32-#34
    }
}