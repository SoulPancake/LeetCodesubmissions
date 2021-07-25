// https://leetcode.com/problems/range-sum-of-bst

class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        int ans=0;
        if(root==null)return ans;
        ans+=rangeSumBST(root.left,low,high);
        if(inRange(root.val,low,high))ans+=root.val;
        ans+=rangeSumBST(root.right,low,high);
        return ans;
    }
    public boolean inRange(int n,int low,int high)
    {
        return n>=low&&n<=high;
    }
}