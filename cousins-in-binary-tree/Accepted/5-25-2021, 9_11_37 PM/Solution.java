// https://leetcode.com/problems/cousins-in-binary-tree

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
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root.val==x || root.val==y)
            return false;
        
        HashMap<Integer,Integer> parents=new HashMap<>();
        HashMap<Integer,Integer> depths=new HashMap<>();
        
        traverse(root,parents,depths,0,0); //ASSSUME DEPTH @ROOT IS 0 & ROOT'S PARENT=0
        return (parents.get(x)!=parents.get(y) && depths.get(x)==depths.get(y));
    }
    private void traverse(TreeNode root,HashMap<Integer,Integer> parents,HashMap<Integer,Integer> depths,int depth,int parent)
    {
        if(root==null)
            return;
        
        parents.put(root.val,parent);
        depths.put(root.val,depth);
        
        traverse(root.left,parents,depths,depth+1,root.val); //Current node is parent of left child
        //Similarly for right child too
        traverse(root.right,parents,depths,depth+1,root.val); //DEPTH IS INCREASED BY 1
        //AND THE PARENT IS THE CURRENT NODE
        
        //This should work
    }
}