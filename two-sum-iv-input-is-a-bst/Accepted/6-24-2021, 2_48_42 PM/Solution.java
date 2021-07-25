// https://leetcode.com/problems/two-sum-iv-input-is-a-bst

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
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> sorted=new ArrayList<>();
        populate(root,sorted);
        
        int i=0;
        int j=sorted.size()-1;
        
        while(i<j)
        {
            if(sorted.get(i)+sorted.get(j)==k)
                return true;
            if(sorted.get(i)+sorted.get(j)<k)
            {
                i++;
            }else{
                j--;
            }
            
        }
        
        return false;
    }
    
    
    private void populate(TreeNode root,List<Integer> sorted)
    {
        if(root==null)return;
        
        //Inorder traversalt to get a sorted array
        
        populate(root.left,sorted);
        
        sorted.add(root.val);
        
        populate(root.right,sorted);
        
        return;
    }
}