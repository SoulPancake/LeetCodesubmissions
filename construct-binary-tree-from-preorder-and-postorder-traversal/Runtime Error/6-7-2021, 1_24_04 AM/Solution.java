// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal

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
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
       return helper(pre,post,0,pre.length-1,0,post.length-1); 
    }
    
    private TreeNode helper(int[] pre,int[] post,int preStart,int preEnd,int postStart,int postEnd)
    {
        if(preStart>preEnd)
            return null;
        
        TreeNode root=new TreeNode(pre[preStart]);
        
        
        if(preStart==preEnd) //Last node case is returned here so Point B wont be triggered
           return root;
        
        int postIndex=postStart; //Index in postOrder where the root value exists!
        while(post[postIndex++]!=pre[preStart+1]); //Point B
        
        int len=postIndex-postStart+1;
        root.left=helper(pre,post,preStart+1,preStart+len,postStart,postIndex);
        root.right=helper(pre,post,preStart+len+1,preEnd,postIndex+1,postEnd-1);
        return root;
        
        
        
    }
}