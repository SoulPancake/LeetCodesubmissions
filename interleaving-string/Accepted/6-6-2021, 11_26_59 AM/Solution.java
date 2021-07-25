// https://leetcode.com/problems/interleaving-string

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        Boolean[][] dp = new Boolean[n+1][m+1];
        if(s3.length() != n+m) return false;
        return foo(s1,s2,s3,0,0,0,n,m,dp);
    }
    
    public boolean foo(String s1, String s2, String s3, int i, int j, int k, int n, int m, Boolean[][] dp){
        if(i==n && j==m) return true;
        if(i<n && j<m && dp[i][j]!=null) return dp[i][j];
        boolean ans = false;
        if(i<n && k<s3.length() && s3.charAt(k) == s1.charAt(i)){
            ans = foo(s1,s2,s3,i+1,j,k+1,n,m,dp);
        }
        if(j<m && k<s3.length() && s3.charAt(k) == s2.charAt(j)){
            ans|= foo(s1,s2,s3,i,j+1,k+1,n,m,dp);
        }
        return dp[i][j]=ans;
    }
}