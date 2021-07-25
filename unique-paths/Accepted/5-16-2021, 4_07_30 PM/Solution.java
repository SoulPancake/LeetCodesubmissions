// https://leetcode.com/problems/unique-paths

class Solution {
    public int uniquePaths(int m, int n) {
        
      //Dynamic progranmming
       //Bottom up approach
        
        int[][] dp=new int[m][n]; //Keeping track of all the different ways
                                      //We can reach each cell in the matrix
                                      //Starting from (0,0)
        for(int i=0;i<dp.length;i++)
            dp[i][0]=1; // For reaching any row's first column
                        //There is only one way to do it
                        // i.e. moving downwards
                        //Because the motion is restricted to downwards and rightwards
        
        for(int i=0;i<dp[0].length;i++)
             dp[0][i]=1; //Only moving rightwards
        
        //For any cell that we are currently on
        //WE could have come from the cell above or the cell left to it
        
         for(int i=1;i<dp.length;i++)
         {
             for(int j=1;j<dp[i].length;j++)
             {
                 dp[i][j]=dp[i-1][j]+dp[i][j-1];
             }
         }
        
        return dp[m-1][n-1];
        
    }
}