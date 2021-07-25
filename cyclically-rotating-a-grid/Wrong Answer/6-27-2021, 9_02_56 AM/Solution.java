// https://leetcode.com/problems/cyclically-rotating-a-grid

class Solution {
    public int[][] rotateGrid(int[][] mat, int k) {
        int N=mat.length;
        for(int i=0;i<k;i++)
        {
            for (int x = 0; x < N / 2; x++) {
            // Consider elements in group
            // of 4 in current square
            for (int y = x; y < N - x - 1; y++) {
                // Store current cell in
                // temp variable
                int temp = mat[x][y];
 
                // Move values from right to top
                mat[x][y] = mat[y][N - 1 - x];
 
                // Move values from bottom to right
                mat[y][N - 1 - x]
                    = mat[N - 1 - x][N - 1 - y];
 
                // Move values from left to bottom
                mat[N - 1 - x][N - 1 - y] = mat[N - 1 - y][x];
 
                // Assign temp to left
                mat[N - 1 - y][x] = temp;
            }
        }
        }
        
        return mat;
    }
}