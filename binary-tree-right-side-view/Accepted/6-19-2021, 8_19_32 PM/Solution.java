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
        List<Integer> l=new ArrayList<>();
        if(root==null)return l;
        Queue<TreeNode> queue=new LinkedList<>();
        
        queue.offer(root);
        
        while(!queue.isEmpty())
        {
            int size=queue.size();
            for(int i=0;i<size;i++)
            {
                TreeNode currentNode=queue.poll();
                if(i==size-1)//Last element on this level
                    l.add(currentNode.val);
                
                if(currentNode.left!=null)queue.offer(currentNode.left);
                
                if(currentNode.right!=null)queue.offer(currentNode.right);
            }
        }
        return l;
    }
}