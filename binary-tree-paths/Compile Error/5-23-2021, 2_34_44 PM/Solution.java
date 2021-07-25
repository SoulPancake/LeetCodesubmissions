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
        List<String> result=new ArrayList<>();
        if(root==null)
            return result;
        String CurrentPath=Integer.toString(root.val);
        if(root.left==null && root.right==null)
            result.add(CurrentPath);
        
        if(root.left!=null)
            dfs(root.left,CurrentPath,result);
        
        if(root.right!=null)
            dfs(root.right,CurrentPath,result);
        
        
        return result;
    }
    
    public void dfs(TreeNode node,String CurrentPath,List<String> result)
    {
        CurrentPath+="->"+node.val;
        
        if(node.right==null &&& node.left==null)
        {result.add(CurrentPath);
         return;
        } 
    }
}