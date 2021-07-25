// https://leetcode.com/problems/maximum-binary-tree

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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        
        if(nums.length==0 || nums==null)
            return null;
      
       int max=nums[0];
       int indexOfMax=0;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]>max)
            {max=nums[i];
             indexOfMax=i;
        }
        
        
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==max)
                indexOfMax=i;
        }
        
        int[] prefix=new int[indexOfMax];
        int[] suffix=new int[nums.length-indexOfMax];
        int k=0;
        for(int i=0;i<indexOfMax;i++)
            prefix[i]=nums[i];
        for(int i=indexOfMax+1;i<nums.length;i++)
             suffix[k++]=nums[i];
        
        
        
        
          TreeNode root=new TreeNode(max,constructMaximumBinaryTree(prefix),constructMaximumBinaryTree(suffix));
        return root;
        
        
        
    }
}