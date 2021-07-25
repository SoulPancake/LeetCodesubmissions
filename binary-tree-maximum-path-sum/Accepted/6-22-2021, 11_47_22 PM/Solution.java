// https://leetcode.com/problems/binary-tree-maximum-path-sum

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

//let's hope this works!

//Awesome that it does! :D
class Solution {
    int result=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        //So we will take a result variable globally so we can access it from our recursive helper method
        if(root==null)return 0; //Edge case
        //Magical helper method
        helper(root);
        return result;
    }
    
    //Now we'll write our helper method
    
    private int helper(TreeNode root)
    {
        if(root==null)return 0;//The values begin from zero at the children of the leaf nodes
        
        //We perform a post order traversal to process it
        int left=helper(root.left); //One important thing to remember is that this helper method returns the straight sum that's why when we add it to the current node we still have a valid path,If we took a sum that would have the root as the middle element of the path then adding to that value wouldn't be a good choice!
        int right=helper(root.right); //Same with this
        //Either of the straight sums,The maximum one is to be chosen and added to the current value to either obtain the maximum or the current node is chosen to obtain the maximum
        
        //Now we'll do the processing part
        //There are three cases
        //1st this current node is the linear end of the path of the greatest sum!
        //So it is the max Straight line sum path which includes the current node and either of the left or the right node's maximum sum
        //It can either be the maximum of the left and right + the current value
        //Or just the current value,Assuming that the left and the right subtrees give us a negative value and this current value is positive and greater that them both!
        int maximumStraightSum=Math.max(Math.max(left,right)+root.val,root.val);
        
        
        //MOving on to the next case we can have the 2nd case
        //Which is when the current node is in the middle of the path to the largest sum ,Which means this current node plus the left and the right parts sum
        //And this value is to be compared with the maximumStraightSum to get the actual max involved in this case
        
        int maximumInvolvingBothsides=Math.max(maximumStraightSum,left+right+root.val);
        //Finally we can say that the result will be the maximum of both of these cases
        //We'll store this globally
        result=Math.max(result,maximumInvolvingBothsides); //Simly mistake hue hue hue Doge crashed from the moon hue hue
        return maximumStraightSum;
    }
}