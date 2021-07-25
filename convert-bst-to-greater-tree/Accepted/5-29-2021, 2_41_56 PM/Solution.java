// https://leetcode.com/problems/convert-bst-to-greater-tree

class Solution {
    int sum=0;
    public TreeNode convertBST(TreeNode root) {
        if(root==null)
            return null;
        //The right subtree of a node contains only nodes with keys greater than the node's key.
        convertBST(root.right);
        sum+=root.val;//update sum value
        root.val=sum;//update root val
        convertBST(root.left);
        return root;
    }
}