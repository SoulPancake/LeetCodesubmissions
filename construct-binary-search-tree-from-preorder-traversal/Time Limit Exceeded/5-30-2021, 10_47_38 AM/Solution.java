// https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal

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
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder.length==0)
            return null;
        return constructPreOrder(preorder,0,preorder.length-1);
    }
    
    private TreeNode constructPreOrder(int[] array,int left,int right)
    {
        if(left>right )
            return null;
        if(left==right)//base case
        {
            TreeNode root=new TreeNode(array[left]);
            return root;
        }
        TreeNode root=new TreeNode(array[left]);
        int index=0;
        for(int i=left;i<=right;i++)
        {
            if(array[i]>array[left])
                {index=i;break;}
        }
        root.left=constructPreOrder(array,left+1,index-1);
        root.right=constructPreOrder(array,index,right);
        return root;
            
    }
}