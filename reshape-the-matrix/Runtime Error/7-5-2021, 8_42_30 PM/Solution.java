// https://leetcode.com/problems/reshape-the-matrix

class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int[][] matrix=new int[r][c];
        int p=0,q=0;
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                matrix[i][j]=mat[p][q];
                if(q==mat[0].length-1){
                    p++;q=0;
                }else{
                    q++;
                }
            }
        }
        
        return matrix;
    }
}