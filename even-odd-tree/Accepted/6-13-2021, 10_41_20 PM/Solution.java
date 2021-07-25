// https://leetcode.com/problems/even-odd-tree

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
    public boolean isEvenOddTree(TreeNode root) {
       if(root==null)return true;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        boolean evenLevel=true; //Initially the level is even (0)
        
        while(!q.isEmpty())
        {
            int size=q.size();
            int prev=evenLevel?Integer.MIN_VALUE:Integer.MAX_VALUE;
            for(int i=0;i<size;i++)
            {
               TreeNode Current=q.poll();
               if(evenLevel && (Current.val%2==0 || Current.val<=prev))
                   return false;
               if(!evenLevel && (Current.val%2!=0 || Current.val>=prev))
                   return false;
                
                prev=Current.val;
                if(Current.left!=null)q.offer(Current.left);
                if(Current.right!=null)q.offer(Current.right);
               
            }
             evenLevel=!evenLevel;
        
         }
        
        return true;
}  
}