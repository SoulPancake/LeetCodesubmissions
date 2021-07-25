// https://leetcode.com/problems/transpose-matrix

class Solution {
    public int[][] transpose(int[][] matrix) {
        int[][] mat=new int[matrix.length][matrix[0].length];
        
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[i].length;j++)
            {
                mat[i][j]=matrix[j][i];
            }
        }
        return mat;
    }
}