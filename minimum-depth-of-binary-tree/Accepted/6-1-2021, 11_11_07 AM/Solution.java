// https://leetcode.com/problems/minimum-depth-of-binary-tree

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
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        if(root.left==null && root.right==null)return 1;
        int left=1+minDepth(root.left);
        int right=1+minDepth(root.right);
        if(left==1 || right==1) //Left is leaf or right is leaf
           return left==1?right:left;  //If left is leaf return right? if right is leaf return left ?
        
        return Math.min(left,right);
    }
}