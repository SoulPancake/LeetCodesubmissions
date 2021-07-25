// https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree

class Solution {
    int c=0;
    public int pseudoPalindromicPaths (TreeNode root) {
        int countFreq[]=new int[10];
        
        find(root,countFreq);
        return c;
        
    }
    private void find(TreeNode root,int countFrequencies[]){
        if(root==null) return;
        if(root.left==null && root.right==null){ //Leaf node reached
             countFrequencies[root.val]++;
            int odd=0;
            for(int i=0;i<10;i++){
                if((countFrequencies[i]&1)!=0) odd++;
            }
            if(odd<2) c++; //If zero or 1's frequency is odd then we can construct a palindrome otherwise if more than one number has odd frequency it is not possible to construct a palindrome using that!
            countFrequencies[root.val]--;
            return;
        }
        countFrequencies[root.val]++; //Adding the current node's val 
        find(root.left,countFrequencies); 
        find(root.right,countFrequencies);
        countFrequencies[root.val]--;//Removing the current node's value
    }
}