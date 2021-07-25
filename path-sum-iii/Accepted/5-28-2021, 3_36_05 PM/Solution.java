// https://leetcode.com/problems/path-sum-iii

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
    int count=0;
    ArrayList<Integer> list=new ArrayList<>();
    public int pathSum(TreeNode root, int targetSum) {
        getSum(root,targetSum);
        return count;
    }
    
    private void getSum(TreeNode root,int sum)
    {
        if(root==null)
            return;
        
        list.add(root.val);
        getSum(root.left,sum);
        getSum(root.right,sum);
        
        //Pre Order??
        
        int temp=0;
        
        for(int i=list.size()-1;i>=0;i--)
        {
            temp+=list.get(i);
            if(temp==sum)
                 count++;
        }
        list.remove(list.size()-1);
    }
}