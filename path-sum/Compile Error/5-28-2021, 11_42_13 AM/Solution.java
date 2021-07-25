// https://leetcode.com/problems/path-sum

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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null)
            return false;
        
        Stack<TreeNode> nodeStack=new Stack<>();
        Stack<Integer> sumStack=new Stack<>();
        
        nodeStack.add(root);
        sumStack.add(targetSum-root.val);
        
        
        while(!nodeStack.isEmpty())
        {
            TreeNode currentNode=nodeStack.pop();
            int CurrentSum=sumStack.pop();
            
            if(currentNode.left==null && currentNode.right==null && if CurrentSum==0 )
                  return true;
            
            if(currentNode.left!=null)
               { nodeStack.add(currentNode.left);
                 sumStack.add(CurrentSum-currentNode.left.val);}
            
            if(currentNode.right!=null)
                { nodeStack.add(currentNode.right);
                 sumStack.add(CurrentSum-currentNode.right.val);}
        }
        
        return false;
    }
}