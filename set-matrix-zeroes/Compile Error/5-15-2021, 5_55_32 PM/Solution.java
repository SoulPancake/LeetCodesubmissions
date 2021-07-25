// https://leetcode.com/problems/set-matrix-zeroes

class Solution {
    public void setZeroes(int[][] matrix) {
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[i].length;j++)
            {
                if(matrix[i][j]==0)
                {
                    MakeZero(nums,i,j);
                }
            }
        }
    }
    
    public void MakeZero(int[][] nums,int i,int j)
    {
        if(i<0 || i> nums.length || j<0 || j >nums[i].length)
            return;
        
        nums[i][j]=0;
        
            MakeZero(nums,i+1,j);
            MakeZero(nums,i,j-1);
            MakeZero(nums,i,j+1);
            MakeZero(nums,i-1,j);
        
    }
}