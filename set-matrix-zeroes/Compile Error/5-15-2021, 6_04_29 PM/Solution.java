// https://leetcode.com/problems/set-matrix-zeroes

class Solution {
    public void setZeroes(int[][] matrix) {
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[i].length;j++)
            {
                if(matrix[i][j]==0)
                {
                    MakeZero(matrix,i,j);
                }
            }
        }
    }
    
    public void MakeZero(int[][] nums,int i,int j)
    {
        for(int b=0;b<matrix.length;b++)
        {
            for(int c=0;c<matrix[i].length;c++)
            {
                if(b==i || c==j)
                    nums[b][c]=0;
            }
        }
        
    }
}