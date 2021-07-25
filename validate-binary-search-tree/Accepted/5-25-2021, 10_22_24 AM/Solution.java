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
     List<TreeNode> l;
        
    public boolean isValidBST(TreeNode root) {
       l=new ArrayList<>();
        
        inOrder(root);
        
        for(int i=1;i<l.size();i++)
        {
            if(l.get(i).val<=l.get(i-1).val)
                return false;
        }
        return true;
    }
    
    public void inOrder(TreeNode root)
    {
        if(root==null)
             return;
        
        inOrder(root.left);
        l.add(root);
        inOrder(root.right);
        
        return;
    }
}