// https://leetcode.com/problems/minimum-number-of-refueling-stops

class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        long[] dp=new long[stations.length+1];
        
        dp[0]=startFuel;
        for(int i=0;i<stations.length;i++)
        {
            for(int t=i;t>=0;t--)
            {
                if(dp[t]>=stations[i][0])
                    dp[t+1]=Math.max(dp[t+1],dp[t]+(long)stations[i][1]);
            }
        }
        
        for(int i=0;i<=stations.length;i++)
            if(dp[i]>=target) return i;
        
        return -1;
    }
}