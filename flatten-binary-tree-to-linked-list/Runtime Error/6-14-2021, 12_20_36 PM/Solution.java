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
        List<Integer> l=new ArrayList<>();
        
        preOrder(root,l); //Populating the list
        
        root.val=l.get(0);
        TreeNode prev=root;
        root.left=null;
        for(int i=1;i<l.size();i++)
        {   TreeNode boot=new TreeNode(l.get(i));
            prev.right=boot;
            prev=boot;
            boot=boot.right;
        }
        
    }
    
    private void preOrder(TreeNode root,List<Integer> l)
    {
        if(root==null)return;
        
        l.add(root.val);
        preOrder(root.left,l);
        preOrder(root.right,l);
        return;
    }
}