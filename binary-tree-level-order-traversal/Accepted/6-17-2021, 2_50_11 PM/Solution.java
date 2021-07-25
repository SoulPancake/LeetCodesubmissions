// https://leetcode.com/problems/binary-tree-level-order-traversal

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> list=new ArrayList<>();
        if(root==null)return list;
        Queue<TreeNode> los=new LinkedList<>();
        
        los.offer(root);
        
        while(!los.isEmpty())
        {
            List<Integer> l=new ArrayList<>();
            int size=los.size();
            for(int i=0;i<size;i++)
            {TreeNode current=los.remove();
             
             l.add(current.val);
             if(current.left!=null)
                 los.offer(current.left);
             if(current.right!=null)
                 los.offer(current.right);
            }
            list.add(l);
        }
        
        return list;
    }
}