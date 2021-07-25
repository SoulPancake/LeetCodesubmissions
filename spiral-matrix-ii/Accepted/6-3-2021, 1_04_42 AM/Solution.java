// https://leetcode.com/problems/spiral-matrix-ii

class Solution {
    public int[][] generateMatrix(int n) {
        
        int[][] matrix=new int[n][n];
        int top=0;
        int bottom=matrix.length-1;
        int left=0;
        int right=matrix[0].length-1;
        int k=1;
        
            while(k<=n*n)
            {
                for(int i=left;i<=right ;i++)
                {
                   matrix[top][i]=k++;;
                }
                top++;
                
                for(int i=top;i<=bottom;i++)
                {
                    matrix[i][right]=k++;
                }
                right--;
                
                for(int i=right;i>=left ;i--)
                {
                    matrix[bottom][i]=k++;
                }
                bottom--;
                for(int i=bottom;i>=top ;i--)
                {
                    matrix[i][left]=k++;
                }
                left++;
            }
        
        
        return matrix;
    }
}