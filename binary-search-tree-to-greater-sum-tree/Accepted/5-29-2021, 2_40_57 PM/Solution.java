// https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree

class Solution {
    int sum=0;
    public TreeNode bstToGst(TreeNode root) {
        if(root==null)
            return null;
        //The right subtree of a node contains only nodes with keys greater than the node's key.
        bstToGst(root.right);
        sum+=root.val;//update sum value
        root.val=sum;//update root val
        bstToGst(root.left);
        return root;
    }
}