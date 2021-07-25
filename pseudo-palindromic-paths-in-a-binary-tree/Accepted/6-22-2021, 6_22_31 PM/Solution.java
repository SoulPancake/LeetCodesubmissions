// https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree

class Solution {
int totalPalindrominPaths;
public int pseudoPalindromicPaths (TreeNode root) {
this.totalPalindrominPaths = 0;
findTotalPalidromicPaths(root,new int[10]);
return totalPalindrominPaths;
}

private void findTotalPalidromicPaths(TreeNode root, int[] countSoFar) {
    if(root==null) return;
    countSoFar[root.val]++;
    if(root.left==null && root.right==null){
        if(checkIfPal(countSoFar)) this.totalPalindrominPaths++;
        countSoFar[root.val]--;
        return;
    }
    findTotalPalidromicPaths(root.left,countSoFar);
    findTotalPalidromicPaths(root.right,countSoFar);
    countSoFar[root.val]--;
}

private boolean checkIfPal(int[] arr){
    boolean hasOdd = false;
    for(int i=1;i<10;i++){
        if(arr[i]%2==0) continue;
        if(hasOdd) return false;
        hasOdd = true;
    }
    return true;
}
}