// https://leetcode.com/problems/maximum-binary-tree-ii

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
    List<Integer> l;
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
         if(val>root.val)
         {
             TreeNode b=new TreeNode(val);
             b.left=root;
             return b;
         }
        l=new ArrayList<>();
        l.add(val);
        populate(root);//Populate the list with all node values
        return construct(0,l.size()-1);
        
    }
    
    private TreeNode construct(int left,int right)
    {
        if(left>right)
             return null;
        int max=Integer.MIN_VALUE;
        for(int i=left;i<=right;i++)
        {
            max=Math.max(max,l.get(i));
        }
        
        int index=left;
        
        for(int i=left;i<=right;i++)
        {
            if(max==l.get(i))
                {index=i;break;}
        }
        
        TreeNode root=new TreeNode(l.get(index));
        if(left==right)
            return root;
        
        root.left=construct(left,index-1);
        root.right=construct(index+1,right);
        return root;
        
    }
    
    private void populate(TreeNode root)
    {
        if(root==null)return;
         l.add(root.val);
        populate(root.left);
       
        populate(root.right);
        return;
    }
}