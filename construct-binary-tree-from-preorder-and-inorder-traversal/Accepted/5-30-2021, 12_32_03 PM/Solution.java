// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal

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
     public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);
        int inIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            TreeNode pre = null;
            
            // check if left ended, we need to pop up and go right
            while (!stack.isEmpty() && stack.peek().val == inorder[inIndex]) {
                inIndex++;
                pre = stack.pop();
            }
            TreeNode node = new TreeNode(preorder[i]);
            if (pre == null) {
                // still go left
                stack.peek().left = node;
            } else {
                // go right
                pre.right = node;
            }
            stack.push(node);
        }
        
        return root;
    }
}