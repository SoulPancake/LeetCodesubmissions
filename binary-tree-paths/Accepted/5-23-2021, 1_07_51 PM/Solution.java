// https://leetcode.com/problems/binary-tree-paths

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
 
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths=new ArrayList<>();
        if(root==null)
            return paths;
        
        dfs(root,"",paths);
        
        return paths;
      }
    
    public void dfs(TreeNode root,String currentPath,List<String> paths)
    {
        currentPath+=root.val; //Adding the current node we're on
        if(root.left==null && root.right==null) //We're at a leaf node
          {
           paths.add(currentPath);    //So we have a path
            return;              
           }
        
        if(root.left!=null)
            dfs(root.left,currentPath+"->",paths);
        
        if(root.right!=null)
            dfs(root.right,currentPath+"->",paths);
     }
    
    
}