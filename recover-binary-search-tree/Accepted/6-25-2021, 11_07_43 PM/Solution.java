// https://leetcode.com/problems/recover-binary-search-tree

class Solution {
   TreeNode firstNode;
   TreeNode secondNode;
   TreeNode preNode;
   public void recoverTree(TreeNode root) {
       backtrace(root); //find the two "discordant" nodes(swapped by mistake)
        //swap the two nodes
        int num = firstNode.val;      
        firstNode.val= secondNode.val;
        secondNode.val = num;
    
}
//BST : if we traverse the tree with inorder traversal, we can get a non-decreasing sequence 
void backtrace(TreeNode root)
{
     if (root == null) return;
    backtrace(root.left);
    if (preNode == null || preNode.val<= root.val) preNode = root; //update the preNode
    else //we found the wrong node
    {
        if (firstNode== null) firstNode = preNode;                 
        secondNode = root; 
    }
    backtrace(root.right);
}
}