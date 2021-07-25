// https://leetcode.com/problems/unique-binary-search-trees-ii

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
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1,n);
    }
    
    private ArrayList<TreeNode> generateTrees(int left,int right)
    { ArrayList<TreeNode> t=new ArrayList<>();
        if(left>right)
        {
           
            t.add(null);
            return t;
        }
        
        for(int i=left;i<=right;i++)
        {
            List<TreeNode> leftList=generateTrees(left,i-1);
            List<TreeNode> rightList=generateTrees(i+1,right);
            
            for(TreeNode c : leftList)
            {
                for(TreeNode d : rightList)
                {
                    TreeNode root=new TreeNode(i);
                    root.left=c;
                    root.right=d;
                    t.add(root);
                }
            }
            
            
        }
        return t;
    }
}