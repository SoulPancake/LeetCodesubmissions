// https://leetcode.com/problems/leaf-similar-trees

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

//Depth first search to reach leaf nodes
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> Leaves1=new ArrayList<>();
        List<Integer> Leaves2=new ArrayList<>();
        
        dfs(Leaves1,root1);
        dfs(Leaves2,root2);
        
        return Leaves1.equals(Leaves2);
        
    }
    
    public void dfs(List<Integer> Leaves,TreeNode root)
    {
        if(root==null)
            return;
        
        if(root.left==null && root.right==null) //Leaf
            Leaves.add(root.val);
        
        dfs(Leaves,root.left);
        dfs(Leaves,root.right);
        
        
        
    }
   
}