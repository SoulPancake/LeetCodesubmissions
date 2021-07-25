// https://leetcode.com/problems/check-completeness-of-a-binary-tree

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
    public boolean isCompleteTree(TreeNode root) {
        boolean SeenANull=false;
        
        Queue<TreeNode> queue=new LinkedList<>();
        
        queue.offer(root);
        
        while(!queue.isEmpty())
        {
            int size=queue.size();
            for(int i=0;i<size;i++)
            {
                TreeNode Current=queue.poll();
                if(Current==null)seenANull=true;
                else{if(seenANull)return false;if(Current.left!=null)queue.offer(Current.left);
                if(Current.right!=null)queue.offer(Current.right);}
            }
        }
        
        return true;
    }
}