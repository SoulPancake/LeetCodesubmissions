// https://leetcode.com/problems/rotate-image

class Solution {
    public void rotate(int[][] matrix) {
        int N=matrix.length;
        
        for(int i=0;i<N;i++)
        {
            for(int j=i;j<N;j++) //Notice this line well
             {                    //If you dont start j from i it will
                                  //double swap
                int swap=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=swap;
            }
        }
        
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N/2;j++)
            {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[i][N-1-j];
                matrix[i][N-1-j]=temp;
            }
        }
    }
}