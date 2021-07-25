// https://leetcode.com/problems/minimum-absolute-difference-in-bst

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
    List<Integer> sorted;
    public int getMinimumDifference(TreeNode root) {
       sorted=new ArrayList<>();
        helper(root); 
        
        int min=Integer.MAX_VALUE;
        
        for(int i=0;i<sorted.size()-1;i++)
        {
            min=Math.min(min,sorted.get(i+1)-sorted.get(i));
        }
        return min;
    }
    
    private void helper(TreeNode root)
    {
        if(root==null)return;
        
        helper(root.left);
        sorted.add(root.val);
        helper(root.right);
        return;
    }
}