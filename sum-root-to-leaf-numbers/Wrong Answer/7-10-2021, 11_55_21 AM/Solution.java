// https://leetcode.com/problems/sum-root-to-leaf-numbers

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
    List<Integer> paths;
    public int sumNumbers(TreeNode root) {
        if(root==null)return 0;
        paths=new ArrayList<>();
        
        helper(root.left,new Integer(root.val));
        helper(root.right,new Integer(root.val));
        
        int sum=0;
        
        for(int c : paths)
            sum+=c;
        return sum;
    }
    
    private void helper(TreeNode root,int valuesSoFar)
    {
        if(root==null)return;
        if(root.left==null && root.right==null)
        {
            valuesSoFar*=10;
            valuesSoFar+=root.val;
            paths.add(valuesSoFar);
            return;
        }
        
         valuesSoFar*=10;
         valuesSoFar+=root.val;
         helper(root.left,new Integer(valuesSoFar));
         helper(root.right,new Integer(valuesSoFar));
         return;
        
    }
}