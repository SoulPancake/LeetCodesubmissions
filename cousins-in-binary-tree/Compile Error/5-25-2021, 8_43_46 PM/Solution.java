// https://leetcode.com/problems/cousins-in-binary-tree

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
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root.val==x || root.val==y)
            return false;
        
        int xParent=-1;
        
        int xHeight=FindHeight(root,xParent,x,0);
        
        int yParent=-1;
        int yHeight=FindHeight(root,yParent,y,0);

        return (xParent!=yParent && xHeight==yHeight);
        
    }
    
    private int FindHeight(TreeNode root,int parent,int val,int height)
    {
        if(root==null)
            return 0;
        
        if(root.val==val)
            return height;
        
        parent=root.val;
        int left=FindHeight(root.left,parent,val,height+1);
        
        if(left) return left;
        
        parent=root.val;
        int right=FindHeight(root.right,parent,val,height+1);
        
        return right;
        
    }
}