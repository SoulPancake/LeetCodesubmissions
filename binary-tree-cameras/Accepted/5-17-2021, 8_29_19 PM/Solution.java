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
class Solution {
    int cameraCount;
    Set<TreeNode> covered;
    public int minCameraCover(TreeNode root) {
        if(root==null)
            return 0;
        cameraCount=0;
        covered=new HashSet<>();
        covered.add(null);
        dfs(root,null); //Root and his parent
        
        return cameraCount;
    }
    
    public void dfs(TreeNode node,TreeNode parent)
    {
        if(node==null)
            return;
        
        dfs(node.left,node);
        dfs(node.right,node);
        
        //Now we are at the bottommost node
        
        //Parent is null and my node is uncovered or any of it's left or right are not covered
        
        if(parent==null && !covered.contains(node) || !covered.contains(node.left) || !covered.contains(node.right))
        {
            cameraCount++;
            covered.add(node);
            covered.add(parent);
            covered.add(node.left);
            covered.add(node.right);
        }
        
        
    }
}