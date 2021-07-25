// https://leetcode.com/problems/find-mode-in-binary-search-tree

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
    Integer prev=null; //To store the value of the node 
                       //Because for a sorted array 
                       //i.e. For InOrder traversal of BST
                       //You'd get a sorted array (increasing)
    int count=1; //A number itself occuring just once
    int max=0; //We'll update this as we go
    public int[] findMode(TreeNode root) {
        //To return we'll use a list because it's dynamically resized
        
        List<Integer> modes=new ArrayList<>();
        
        Traverse(modes,root);
        
        int[] result=new int[modes.size()];
        
        for(int i=0;i<modes.size();i++)
           result[i]=modes.get(i); //I think this should work
        
        
        //We need to return an array so we will convert the list to
        //an array
        return result;
    }
    
    //Now we'll write our recursive helper function
    //Simulating inOrder traversal and comparision @ eachstep
    
    private void Traverse(List<Integer> modes,TreeNode root)
    {
        //Base cases
        if(root==null) return;
        
        Traverse(modes,root.left); //Left first
        
        
        if(prev!=null) //Because initially it is null so our comparisions won't work
        {
            if(prev==root.val) //It has the same value as the previous
                count++;   //Frequency for that particular value can be increased
            else
                count=1;    //Frequency won't grow for this value so we reset count
        }
           
           if(count>max)
           {
               max=count; //New max freq is that of the current node val
               modes.clear(); //Removing all pre=existing nodes to add this new one
               modes.add(root.val);
           }else if(count==max) //The frequency of this number is same as the max frq(mode ) so far
           {
              modes.add(root.val); //This is the case of multiple modes
           }else
           {
               count=1;
           }
           prev=root.val; //We forgot to update the previous when we get to the next node
           Traverse(modes,root.right); //Right later because we are performing inOrder traversal
           //As inorder traversal provides us a sorted ascending ordered element list
           
           
           //This should work
    }
    
}