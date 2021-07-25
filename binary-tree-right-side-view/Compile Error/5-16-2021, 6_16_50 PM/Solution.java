// https://leetcode.com/problems/binary-tree-right-side-view

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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> right=new ArrayList<>();
        
        if(root==null)
            return right;
        
        
        //Do BFS So a queue
        
        Queue<TreeNode> queue=new Queue<>();
        
        queue.add(root);
        
        while(!queue.isEmpty())
        {
            int size=queue.size(); //How many things in the current level
            
            for(int i=0;i<size;i++)
            {
                TreeNode current=queue.remove();
                if(i==size-1) //RIGHTMOST 
                {
                    right.add(current.val);
                }
                
                if(current.left!=null)
                    queue.add(root.left);
                
                if(current.right!=null)
                    queue.add(root.right);
            }
        }
        
        return right;
        
        
    }
}