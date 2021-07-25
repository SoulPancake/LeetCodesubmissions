// https://leetcode.com/problems/delete-node-in-a-bst

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
    List<Integer> inOrder=new ArrayList<>();
    public TreeNode deleteNode(TreeNode root, int key) {
           if(root==null)return root;
           inOrder(root);
           return SeekAndDestroy(root,key);
        
    }
    
    private void inOrder(TreeNode root)
    {
        if(root==null)return;
        
        inOrder(root.left);
        inOrder.add(root.val);
        inOrder(root.right);
        return;
    }
    
    
    private TreeNode SeekAndDestroy(TreeNode root,int key)
    {
        //1st case null nothing to do
        if(root==null)return null;
         if(root.val==key)
        {
           if(root.left==null && root.right==null)//If it's a leaf node simply remove it
               {root=null;return null;}
            if(root.left!=null)
            {
                root.val=InOrderPredecessor(key);
                root.left=SeekAndDestroy(root.left,root.val);
                return root;
            }
             if(root.right!=null)
             {
                 root.val=InOrderSuccessor(key);
                 root.right=SeekAndDestroy(root.right,root.val);
                 return root;
             }
             
         
         }
        
        if(root.val<key)
        {
            root.right=SeekAndDestroy(root.right,key);
            
        }else
            root.left=SeekAndDestroy(root.left,key);
         
        
        return root;
    }
    
    
    private int InOrderPredecessor(int key)
    {
        for(int i=1;i<inOrder.size();i++)
        {
            if(inOrder.get(i)==key)
                return inOrder.get(i-1);
        }
        return -1;
    }
    
    private int InOrderSuccessor(int key)
    {
          for(int i=0;i<inOrder.size()-1;i++)
        {
            if(inOrder.get(i)==key)
                return inOrder.get(i+1);
        }
        
        return -1;
    }
    
}