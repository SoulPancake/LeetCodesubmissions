// https://leetcode.com/problems/range-sum-of-bst

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
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null)return 0;
        
        if(root.val>=low && root.val<=high)
            return root.val+rangeSumBST(root.left,low,high)+rangeSumBST(root.right,low,high);
        else if(root.val < low)
            return rangeSumBST(root.right,low,high);
        else
            return rangeSumBST(root.left,low,high);
        
        
    }
}

//If root is less than low then we will search only in the right subtree
//If root is larger than high then we will search only in the left subtree
//If root lies within the range then we will add the total sum of both the results of left and right subtrees