// https://leetcode.com/problems/game-of-life

class Solution {
    public void gameOfLife(int[][] board) {
        int[][] directions=new int[][]{{-1,-1},{-1,0},{-1,1},{1,1},{0,1},{1,-1},{0,-1},{1,0}};
        //int[][] nextState=new int[board.length][board[0].length];
        
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[i].length;j++)
            {
                int LiveNeighbours=0;
                
                for(int[] direction : directions)
                {
                    int index=i+direction[0];
                    int jindex=j+direction[1];
                    if(index>=0 && index<board.length && jindex>=0 && jindex<board[0].length && (board[index][jindex]==1 || board[index][jindex]==5))LiveNeighbours++;
                }
                
                if(board[i][j]==1)
                {
                    if(LiveNeighbours<2 || LiveNeighbours>3)board[i][j]=5;//Live to dead 5
                    
                }else
                {
                    if(LiveNeighbours==3)board[i][j]=3;//Dead to live
                }
            }
        }
        
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[i].length;j++)
            {
                if(board[i][j]==5)board[i][j]=0;
                if(board[i][j]==3)board[i][j]=1;
            }
        }
    }
}