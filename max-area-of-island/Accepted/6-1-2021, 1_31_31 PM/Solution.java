// https://leetcode.com/problems/max-area-of-island

class Solution {
    
    public int maxAreaOfIsland(int[][] grid) {
        int max=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[i].length;j++)
            {
                if(grid[i][j]==1)
                 max=Math.max(sink(grid,i,j),max);
            }
        }
        
        return max;
    }
    private int sink(int[][] grid,int i,int j)
    {
        if(i<0 || i> grid.length-1 || j<0 || j>= grid[0].length || grid[i][j]==0)
             return 0;
        grid[i][j]=0; //Sink
        return 1+sink(grid,i+1,j)+sink(grid,i,j+1)+sink(grid,i-1,j)+sink(grid,i,j-1);
    
    }
}