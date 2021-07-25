// https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree

class Solution {
    int c=0;
    public int pseudoPalindromicPaths (TreeNode root) {
        int count[]=new int[10];
        
        find(root,count);
        return c;
        
    }
    void find(TreeNode root,int count[]){
        if(root==null) return;
        if(root.left==null && root.right==null){
             count[root.val]++;
            int odd=0;
            for(int i=0;i<10;i++){
                if((count[i]&1)!=0) odd++;
            }
            if(odd<2) c++;
            count[root.val]--;
            return;
        }
        count[root.val]++;
        find(root.left,count);
        find(root.right,count);
        count[root.val]--;
    }
}