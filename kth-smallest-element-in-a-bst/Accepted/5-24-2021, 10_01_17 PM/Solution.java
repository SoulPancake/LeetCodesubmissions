// https://leetcode.com/problems/kth-smallest-element-in-a-bst

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

//The Kth thing in the in-order traversal would give us the Kth smallest 
//Element in a binary search tree
class Solution {
    List<TreeNode> l;
    public int kthSmallest(TreeNode root, int k) {
        l=new ArrayList<>();
        inOrder(root);
        return l.get(k-1).val;
    }
    
    private void inOrder(TreeNode root)
    {
        if(root==null)
            return;
        inOrder(root.left);
        l.add(root);
        inOrder(root.right);
        return;
    }
}