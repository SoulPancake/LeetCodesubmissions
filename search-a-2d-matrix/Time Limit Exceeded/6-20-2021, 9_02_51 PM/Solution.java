// https://leetcode.com/problems/search-a-2d-matrix

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
       int i=0;
       int j=0;
        while(i<matrix.length && j<matrix[0].length)
        {
            if(matrix[i][j]==target)
                return true;
            else if(matrix[i][j]<target && matrix[i][matrix[0].length-1]>=target)
            {
                for(int p=1;p<matrix[0].length;p++)
                    if(matrix[i][p]==target)return true;
            }else if(matrix[i][matrix[0].length-1]<target)
            {
                i++;
                j=0;
            }
            
        }
        return false;
    }
    
}