// https://leetcode.com/problems/search-a-2d-matrix

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
      int row=matrix.length;
      int col=matrix[0].length;
        
        if(row==1&&col==1)
           return matrix[0][0]==target;
        
        int j=0,i=row-1;
         while(i<row&&j<col&&j>=0&&i>=0)
        {
              if(matrix[i][j]>target)
                i--;

               else if(matrix[i][j]<target)
                   j++;
               else
                 return true;
         }
        
         return false;
    }
    
}