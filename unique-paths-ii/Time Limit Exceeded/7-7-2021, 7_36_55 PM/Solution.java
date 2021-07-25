// https://leetcode.com/problems/unique-paths-ii

class Solution {
    int paths=0;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    
        
       dfs(obstacleGrid,0,0);
        return paths;
    }
    
    private void dfs(int[][] G,int i,int j)
    {
        if(i>G.length-1 || i<0 || j>G[0].length-1 ||  j<0 || G[i][j]==1 )
            return;
        if(i==G.length-1 && j==G[0].length-1)
        {
            paths++;
            return;
        }
        
        dfs(G,i+1,j);
        dfs(G,i,j+1);
        return;
    }
}