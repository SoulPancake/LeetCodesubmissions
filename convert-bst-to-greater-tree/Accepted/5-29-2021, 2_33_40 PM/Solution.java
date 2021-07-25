// https://leetcode.com/problems/convert-bst-to-greater-tree

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
    public TreeNode convertBST(TreeNode root) {
        l=new ArrayList<TreeNode>();
        inOrder(root); //Ascending sorted List
        populateNodes(root);
        
        return root;
    }
    
    private void populateNodes(TreeNode root)
    {
        if(root==null)
            return;
        
        populateNodes(root.left);
        root.val=SumOfNexts(root);
        populateNodes(root.right);
        
    }
    
    private int SumOfNexts(TreeNode root)
    {
        int begin=0;
        for(int i=0;i<l.size();i++)
        {
            if(l.get(i)==root)
            {
                begin=i;
                break;
            }
        }
        int sum=0;
        for(int i=begin;i<l.size();i++)
        {
            sum+=l.get(i).val;
        }
        return sum;
    }
    
    private void inOrder(TreeNode root)
    {
        if(root==null)
            return;
        
        inOrder(root.left);
        l.add(root);
        inOrder(root.right);
    }
}