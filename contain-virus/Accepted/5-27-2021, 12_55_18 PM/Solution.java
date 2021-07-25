// https://leetcode.com/problems/contain-virus

class Solution {
    class Info{
        int wallsToBuild;
        Set<Integer> threatenArea;
        Set<Integer> origArea;
        public Info(int x, Set<Integer> threatenArea, Set<Integer> origArea){
            this.wallsToBuild = x;
            this.threatenArea = threatenArea;
            this.origArea = origArea;
        }
    }
    int res = 0;
    public int containVirus(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        PriorityQueue<Info> threatenAreas = new PriorityQueue<Info>((a,b)->b.threatenArea.size()-a.threatenArea.size());
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] == 1){
                    Set<Integer> threatenArea = new HashSet();
                    Set<Integer> origArea = new HashSet();
                    int wallsToBuild = dfs(i, j, grid, threatenArea, origArea);
                    if(threatenArea.size()>0)
                        threatenAreas.offer(new Info(wallsToBuild, threatenArea, origArea));
                }
            }
        }
        if(threatenAreas.isEmpty()) return res;
        Info largestArea = threatenAreas.poll();
        res += largestArea.wallsToBuild;
        buildWalls(largestArea.origArea, grid);
        while(!threatenAreas.isEmpty()){
            Info nextArea = threatenAreas.poll();
            Set<Integer> origThreatenArea = nextArea.threatenArea;
            Set<Integer> newArea = new HashSet();
            Iterator<Integer> iter = origThreatenArea.iterator();
            while(iter.hasNext()){
                int pos = iter.next();
                int i = pos/51;
                int j = pos%51;
                grid[i][j] = 1;
            }    
        }
        resetGrid(grid);
        return containVirus(grid);
    }
    
    public void resetGrid(int[][] grid){
        int rows = grid.length;
        int cols = grid[0].length;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] > 0)
                    grid[i][j] = 1;
            }
        }
    }
    
    public void buildWalls(Set<Integer> area, int[][] grid){
        Iterator<Integer> iter = area.iterator();
        while(iter.hasNext()){
            int next = iter.next();
            grid[next/51][next%51] = -1;
        }
    }
    
    public int dfs(int i, int j, int[][] grid, Set<Integer> threatenArea, Set<Integer> origArea){
        if(i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] == 2 || grid[i][j] == -1)
            return 0;
        if(grid[i][j] == 0){
            threatenArea.add(i*51 + j);
            return 1;
        }
        origArea.add(i*51+j);
        grid[i][j] = 2;
        int res = 0;
        res += dfs(i-1, j, grid, threatenArea, origArea);
        res += dfs(i+1, j, grid, threatenArea, origArea);
        res += dfs(i, j-1, grid, threatenArea, origArea);
        res += dfs(i, j+1, grid, threatenArea, origArea);
        return res;
    }
}