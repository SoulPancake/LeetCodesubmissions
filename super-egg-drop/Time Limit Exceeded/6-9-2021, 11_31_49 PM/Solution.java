// https://leetcode.com/problems/super-egg-drop

class Solution {
    public int superEggDrop(int k, int n) {
        if(k==1)return n;
        if(n==1 || n==0)return n;
        
        
        int[][] dp=new int[k+1][n+1]; //Rows and eggs
        
        
        
        
        for(int i=0;i<n+1;i++) //1 egg so drops=no. of floors
            dp[1][i]=i;
        
        for(int i=0;i<n+1;i++) //No eggs
            dp[0][i]=0;
        
        for(int i=0;i<k+1;i++) //No floors
            dp[i][0]=0;
        
        for(int i=1;i<k+1;i++) //One floor ,So one drop!
            dp[i][1]=1;
        
        for(int i=2;i<=k;i++)
        {
            for(int j=2;j<=n;j++)
            {
                dp[i][j]=Integer.MAX_VALUE;
                
                for(int attemptFloor=1;attemptFloor<=j;attemptFloor++)
                {
                    int costOfWorstOutcome=1+Math.max(dp[i-1][attemptFloor-1],dp[i][j-attemptFloor]);
                    
                    dp[i][j]=Math.min(dp[i][j],costOfWorstOutcome);
                }
            }
        }
        
        return dp[k][n];
        
    }
}