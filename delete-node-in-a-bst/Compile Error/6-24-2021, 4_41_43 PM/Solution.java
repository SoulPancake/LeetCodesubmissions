// https://leetcode.com/problems/delete-node-in-a-bst

class Solution {
    
    public TreeNode deleteNode(TreeNode root, int key) {
           if(root==null)return root;
           return SeekAndDestroy(root,key);
        
    }
    
  private TreeNode SeekAndDestroy(TreeNode root,int key)
    {
        //1st case null nothing to do
        if(root==null)return null;
         if(root.val==key)
        {
           if(root.left==null && root.right==null)//If it's a leaf node simply remove it
               {root=null;return null;}
            if(root.left!=null) //If it's not a leaf simply replace it with it's InOrderPred and delete that value from the left subtree
            {
                root.val=InOrderPredecessor(key);
                root.left=SeekAndDestroy(root.left,root.val);
                return root;
            }
             if(root.right!=null) //If it's not a leaf simply replace it with it's InOrderSucc and delete that value from the right subtree
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
    
    
     private int InOrderPredecessor(TreeNode root){
        root = root.left;
        while(root.right != null) root = root.right;
        return root.val;
    }
    private int InOrderSuccessor(TreeNode root){
        root = root.right;
        while(root.left != null) root = root.left;
        return root.val;
    }
    
}