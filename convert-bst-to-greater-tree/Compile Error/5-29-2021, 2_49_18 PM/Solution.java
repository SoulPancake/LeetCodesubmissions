// https://leetcode.com/problems/convert-bst-to-greater-tree

class Solution {
    in sum=0;
    public TreeNode convertBST(TreeNode root) {
        if(root==null)
            return null;
        
        convertBST(root.right);
        sum+=root.val;
        root.val=sum;
        convertBST(root.left);
        return root;
    }
}