// https://leetcode.com/problems/increasing-order-search-tree

class Solution {
TreeNode head = null;
TreeNode prev = null; 
public TreeNode increasingBST(TreeNode root) {
    inorder(root);
    prev.left = null;
    return head;
}

void inorder(TreeNode node)
{
    if(node == null) return;
    inorder(node.left);
    if(prev == null)
    {
        head = node;
        prev = node;
    }
    else
    {
        prev.left = null;
        prev.right = node;
        prev = node;
    }
    inorder(node.right);
}
}