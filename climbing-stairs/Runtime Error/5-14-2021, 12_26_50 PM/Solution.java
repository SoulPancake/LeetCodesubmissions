// https://leetcode.com/problems/climbing-stairs

class Solution {
    public int climbStairs(int n) {
        //Dynamic programming Bottom up approach possibly
        
        int[] dp=new int[n+1];
        
        dp[0]=1; //1 way to climb zero stairs is you don't climb it
        dp[1]=1;
        dp[2]=2;
        dp[3]=3;
        for(int i=4;i<=n;i++)
        {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}