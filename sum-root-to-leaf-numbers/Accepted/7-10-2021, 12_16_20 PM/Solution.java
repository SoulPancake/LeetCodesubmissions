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
    public int sumNumbers(TreeNode root) {
   
        
        return sumNumbers(root,0); // 0 is the current sum
    }
    private int sumNumbers(TreeNode root,int sumSoFar)
    {
        if(root==null)return 0;//Didn't find a path
        
        sumSoFar*=10;
        sumSoFar+=root.val;
        if(root.left==null && root.right==null)//leaf node
        {
            return sumSoFar;
        }
        
        return sumNumbers(root.left,sumSoFar)+sumNumbers(root.right,sumSoFar);
        
    }
}