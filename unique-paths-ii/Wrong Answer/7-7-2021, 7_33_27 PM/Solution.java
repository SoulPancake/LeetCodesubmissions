// https://leetcode.com/problems/unique-paths-ii

class Solution {
    int paths=0;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int obstaclei=obstacleGrid.length/2;
        int obstaclej=obstacleGrid[0].length/2;
        
       dfs(obstacleGrid,0,0,obstaclei,obstaclej);
        return paths;
    }
    
    private void dfs(int[][] G,int i,int j,int oi,int oj)
    {
        if(i>G.length-1 || i<0 || j>G[0].length-1 ||  j<0 || (i==oi && j==oj ))
            return;
        if(i==G.length-1 && j==G[0].length-1)
        {
            paths++;
            return;
        }
        
        dfs(G,i+1,j,oi,oj);
        dfs(G,i,j+1,oi,oj);
        return;
    }
}