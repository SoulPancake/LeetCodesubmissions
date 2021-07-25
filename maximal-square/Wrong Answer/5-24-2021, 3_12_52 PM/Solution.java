// https://leetcode.com/problems/maximal-square

class Solution {
    public int maximalSquare(char[][] matrix) {
        
        
        if(matrix.length==0)
           return 0;
        
        int max=0;
        int[][] dp=new int[matrix.length][matrix[0].length];
        
        for(int i=0;i<matrix[0].length;i++)
        {
            dp[0][i]=matrix[0][i];
            max=Math.max(max,dp[0][i]);
            //Maximum Area of the first row will be that
        }
        for(int i=0;i<matrix.length;i++)
        {
            dp[i][0]=matrix[i][0];
            max=Math.max(max,dp[i][0]);//Maximum area of the first column will be that itself
        }
        
        for(int i=1;i<matrix.length;i++)
        {
            for(int j=1;j<matrix[i].length;j++)
            {
                if(matrix[i][j]=='1')
                { dp[i][j]=Math.min(dp[i][j-1],Math.min(dp[i-1][j],dp[i-1][j-1]))+1;
                max=Math.max(max,dp[i][j]);
            }}
        }
        
        return max*max;
    }
}