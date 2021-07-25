// https://leetcode.com/problems/nearest-exit-from-entrance-in-maze

class Solution {
     int shortest;
    public int nearestExit(char[][] maze, int[] entrance) {
        shortest=Integer.MAX_VALUE;
       dfs(maze,entrance[0],entrance[1],0);
        return shortest==Integer.MAX_VALUE?-1:shortest;
    }
    private void dfs(char[][] maze,int x,int y,int pathLength)
    {
        if(maze[x][y]=='+')
        {
            pathLength--;
            return;
        }
        
        if(x<=0 || y<=0 || x>=maze.length-1 || y>=maze[0].length-1) //Pathfound,Out of bounds
        {
            shortest=Math.min(shortest,pathLength);
            return;
        }
        maze[x][y]='+';
        if(x+1<maze.length && maze[x+1][y]!='+')
         dfs(maze,x+1,y,pathLength+1);
        maze[x][y]='.';
        maze[x][y]='+';
        if(x-1>=0 && maze[x-1][y]!='+')
         dfs(maze,x-1,y,pathLength+1);
         maze[x][y]='.';
        maze[x][y]='+';
        if(y-1>=0 && maze[x][y-1]!='+')
           dfs(maze,x,y-1,pathLength+1); 
         maze[x][y]='.';
        maze[x][y]='+';
        if(y+1<maze[0].length && maze[x][y+1]!='+')
           dfs(maze,x,y+1,pathLength+1); 
         maze[x][y]='.';
        
        
    }
}