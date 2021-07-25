// https://leetcode.com/problems/all-elements-in-two-binary-search-trees

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
    PriorityQueue<Integer> pq;
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        pq=new PriorityQueue<>();
        helper(root1);
        helper(root2);
        List<Integer> result=new ArrayList<>();
        while(!pq.isEmpty())
            result.add(pq.poll());
        
        return result;
    }
    
    private void helper(TreeNode root)
    {
        if(root==null)return;
        
        helper(root.left);
        pq.add(root.val);
        helper(root.right);
        return;
    }
}