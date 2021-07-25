// https://leetcode.com/problems/jump-game-vi

class Solution {
    public int maxResult(int[] nums, int k) {
        int n=nums.length;
        int[] dp=new int[n];
        
        dp[0]=nums[0];
        
        for(int i=1;i<nums.length;i++)
        {
            dp[i]=Integer.MIN_VALUE;
            
            for(int j=i-1;j>=Math.max(i-k,0);j--)
               { dp[i]=Math.max(dp[i],dp[j]+nums[i]);
            if(nums[j]>=0)break;}
        }
        
        return dp[n-1];
    }
    
}