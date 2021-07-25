// https://leetcode.com/problems/egg-drop-with-2-eggs-and-n-floors

class Solution {
    public int twoEggDrop(int n) {
        int[][] dp=new int[3][n+1]; //No.of eggs+1 and no.of floors +1
        
        for(int i=0;i<n+1;i++) //No of eggs is zero
            dp[0][i]=0;
        
        for(int i=0;i<3;i++) //No of floors is zero
            dp[i][0]=0;
        
        for(int i=0;i<n+1;i++) //One egg so n drops
            dp[1][i]=i;
        
        dp[2][1]=1;
        
        for(int j=2;j<=n;j++)
        {
           dp[2][j]=Integer.MAX_VALUE;
            
          int maximumObtainedWorstCase=1+Math.max(dp[2][n-j],dp[1][j-1]);
            
            
           dp[2][j]=Math.min(dp[2][j],maximumObtainedWorstCase);  
        }
        
        return dp[2][n];
        
        
    }
}