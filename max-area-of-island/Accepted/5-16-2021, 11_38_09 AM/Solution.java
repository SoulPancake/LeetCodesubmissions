// https://leetcode.com/problems/max-area-of-island

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
       //  dfs? and sink
        
        int MaxArea=0;
        
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[i].length;j++)
            {
                if(grid[i][j]==1)
                {
                    MaxArea=Math.max(findArea(grid,i,j),MaxArea);  //Sink and calc area
                }
                 
            }
           
        }
        
        return MaxArea;
    }
    
    public int findArea(int[][] grid,int i,int j)
    {
        if(i<0 || i>=grid.length || j<0 || j>=grid[i].length || grid[i][j]==0)
             return 0;
        
        grid[i][j]=0; //Sinking
        int count=1; //The cell we are on and then 
        count+=findArea(grid,i+1,j)+findArea(grid,i-1,j)+findArea(grid,i,j+1)+findArea(grid,i,j-1);         //Adding the surrounding cells
        return count;
        
        
    }
}