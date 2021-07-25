// https://leetcode.com/problems/binary-tree-cameras

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

// 2-> Node has camera
// 1-> Node is covered by a camera
// 0-> Node is not covered by any cameras


//Space complexity proporitional to H of tree for recursion stack
class Solution {
    int cam;
    public int minCameraCover(TreeNode root) {
        cam=0;
        int ans=dfs(root); //If root was covered we'd get 1 
        //0,1 or 2         //If it wasn't covered we must add a camera at this postion
        
        return (ans==0)?cam+1:cam;
        
        
    }
    public int dfs(TreeNode node)
    {
        if(node==null) return 1; //Leaf's children  will be covered by cam @ leaf
        
        int left=dfs(node.left);
        int right=dfs(node.right);
        
         //Now check if we need to add the camera or not
         //Camera will only be added if my left or right returns 0
         //So we will add a camera so out child is covered by camera
        
        if(left==0 || right==0)
           {
            cam++;
            return 2; //This node has a camera
            }
        else if(left==2 || right==2)
            return 1; //Covered
        else
            return 0; //Wasn't covered with camera
        
    }
}