// https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix

class Solution {
    public int countNegatives(int[][] grid) {
        int neg=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=grid[i].length-1;j>=0;j--)
            {
                if(grid[i][j]<0)
                    neg++;
                else
                    break;
            }
        }
        return neg;
    }
}