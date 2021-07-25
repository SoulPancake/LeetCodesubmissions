// https://leetcode.com/problems/set-matrix-zeroes

class Solution {
    public void setZeroes(int[][] matrix) {
        
        HashSet<Integer> Row=new HashSet<Integer>();
        HashSet<Integer> Column=new HashSet<Integer>();
        
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[i].length;j++)
            {
                if(matrix[i][j]==0)
                {
                    Row.add(i);
                    Column.add(j);
                }
            }
        }
        
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[i].length;j++)
            {
                if(Row.contains(i) || Column.contains(j) )
                    matrix[i][j]=0;
            }
        }
    }
    
    
}