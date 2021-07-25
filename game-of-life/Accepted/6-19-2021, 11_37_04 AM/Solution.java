// https://leetcode.com/problems/game-of-life

class Solution {
    public void gameOfLife(int[][] board) {
        int[][] directions=new int[][]{{-1,-1},{-1,0},{-1,1},{1,1},{0,1},{1,-1},{0,-1},{1,0}};
        int[][] nextState=new int[board.length][board[0].length];
        
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[i].length;j++)
            {
                int LiveNeighbours=0;
                
                for(int[] direction : directions)
                {
                    int index=i+direction[0];
                    int jindex=j+direction[1];
                    if(index>=0 && index<board.length && jindex>=0 && jindex<board[0].length && board[index][jindex]==1)LiveNeighbours++;
                }
                
                if(board[i][j]==1)
                {
                    if(LiveNeighbours==2 || LiveNeighbours==3)nextState[i][j]=1;
                    
                }else
                {
                    if(LiveNeighbours==3)nextState[i][j]=1;
                }
            }
        }
        
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[i].length;j++)
            {
                board[i][j]=nextState[i][j];
            }
        }
    }
}