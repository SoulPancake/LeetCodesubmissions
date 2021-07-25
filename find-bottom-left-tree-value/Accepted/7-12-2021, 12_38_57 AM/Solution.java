// https://leetcode.com/problems/find-bottom-left-tree-value

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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty())
        {
            root=q.poll();
            
            if(root.right!=null)q.offer(root.right);
            if(root.left!=null)q.offer(root.left);
        }
        
        //LAST THING TO BE POLLED FROM YTHE QUEUE WOUL DBE THE LEFT M OSYT NODE

        return root.val;
    }
}