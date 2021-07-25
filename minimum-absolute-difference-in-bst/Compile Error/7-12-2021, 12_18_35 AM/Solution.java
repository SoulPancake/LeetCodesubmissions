// https://leetcode.com/problems/minimum-absolute-difference-in-bst

class Solution {
int min;
int prev;
public void minDiff(TreeNode root)
{
if(root==null)
{
return;
}

   if(root.left!=null)
   {
       minDiff(root.left);
   }
   
   min=Math.min(min,Math.abs(prev-root.val));
   prev=root.val;
   
   if(root.right!=null)
   {
       minDiff(root.right);
   }
   
   return;
}
public int minDiffInBST(TreeNode root) {
min=100001;

    prev=-5000000;
    minDiff(root);
    
    return min;
    
}
}