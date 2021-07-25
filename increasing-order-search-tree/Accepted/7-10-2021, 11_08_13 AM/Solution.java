// https://leetcode.com/problems/increasing-order-search-tree

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
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> inOrder=new ArrayList<>();
        helper(inOrder,root);
        return create(inOrder);
            

        }
    
    private TreeNode create(List<Integer> inOrder)
    {
        if(inOrder.isEmpty())return null;
        TreeNode node=new TreeNode(inOrder.get(0));
        node.left=null;
        inOrder.remove(0);//Removing object at index 0
        node.right=create(inOrder);
        return node;
    }
        
        
    
    private void helper(List<Integer> inOrder,TreeNode root)
    {
        if(root==null)return;
        helper(inOrder,root.left);
        inOrder.add(root.val);
        helper(inOrder,root.right);
        return;
    }
}