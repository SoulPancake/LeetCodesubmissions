// https://leetcode.com/problems/maximum-binary-tree-ii

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
   public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if(null == root) {
            return new TreeNode(val);
        }
        else {
            if(root.val < val) {
                TreeNode nroot = new TreeNode(val);
                nroot.left = root;
                return nroot;
            }
            else {
                root.right = insertIntoMaxTree(root.right, val);
                return root;
            }
        }
    }
}