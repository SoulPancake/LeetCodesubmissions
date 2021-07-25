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
 
 
 class Solution {
    public int findBottomLeftValue(TreeNode root) {
     List<List<Integer>> LOS=new ArrayList<>();
        
      Queue<TreeNode> q=new LinkedList<>();
       
       q.offer(root);
        
        while(!q.isEmpty())
        {
            int size=q.size();
            List<Integer> currentLevel=new ArrayList<>();
            for(int i=0;i<size;i++)
            {
                TreeNode current=q.poll();
                currentLevel.add(current.val);
                if(current.left!=null)q.offer(current.left);
                if(current.right!=null)q.offer(current.right);
            }
            LOS.add(currentLevel);
        }
        
        return LOS.get(LOS.size()-1).get(0);
    }
}
 */
class Solution {
    public int findBottomLeftValue(TreeNode root) {
         List<Integer> LOS=new ArrayList<>();
        
      Queue<TreeNode> q=new LinkedList<>();
       
       q.offer(root);
        
        while(!q.isEmpty())
        {
            int size=q.size();
            List<Integer> currentLevel=new ArrayList<>();
            for(int i=0;i<size;i++)
            {
                TreeNode current=q.poll();
                currentLevel.add(current.val);
                if(current.left!=null)q.offer(current.left);
                if(current.right!=null)q.offer(current.right);
            }
          LOS=currentLevel;
        }
        
        return LOS.get(0);
    }
}