// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null)return result;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        boolean odd=false;
        //Even LR    Odd RL
        while(!queue.isEmpty())
        {
            int size=queue.size();
            List<Integer> currentLevel=new ArrayList<>();
            if(!odd) //Even level L TO R
            {
                for(int i=0;i<size;i++)
                {
                    TreeNode current=queue.poll();
                    currentLevel.add(current.val);
                    if(current.left!=null)queue.offer(current.left);
                    if(current.right!=null)queue.offer(current.right);
                }
                
            }else{
                 for(int i=size-1;i>=0;i--)
                {
                    TreeNode current=queue.poll();
                    currentLevel.add(current.val);
                    if(current.left!=null)queue.offer(current.left);
                    if(current.right!=null)queue.offer(current.right);
                }
            }
            
            if(odd)Collections.reverse(currentLevel);
            odd=!odd;
            result.add(currentLevel);
        }
        
        return result;
        
    }
}