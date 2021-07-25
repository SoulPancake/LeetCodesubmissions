// https://leetcode.com/problems/balance-a-binary-search-tree

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
    List<Integer> l;
    public TreeNode balanceBST(TreeNode root) {
        l=new ArrayList<>();
        inOrder(root);
        
        return construct(0,l.size()-1);
    }
    private void inOrder(TreeNode root)
    {
        if(root==null) return;
        
        inOrder(root.left);
        l.add(root.val);
        inOrder(root.right);
        return;
    }
    
    private TreeNode construct(int left,int right)
    {
        if(left>right)
            return null;
        int mid=left+(right-left)/2;
        TreeNode root=new TreeNode(l.get(mid));
        if(left==right)
            return root;
        root.left=construct(left,mid-1);
        root.right=construct(mid+1,right);
        return root;
        
        
    }
}