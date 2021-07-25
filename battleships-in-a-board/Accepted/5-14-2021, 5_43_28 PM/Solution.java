// https://leetcode.com/problems/battleships-in-a-board

class Solution {
    public int countBattleships(char[][] board) {
        int numBattleships=0;
        
       for(int i=0;i<board.length;i++)
       {
           for(int j=0;j<board[i].length;j++)
           {
               if(board[i][j]=='.')
               {
                  continue;
               }
               if(i>0 && board[i-1][j]=='X')   //coming from the top   //Iterative solution
                   continue;                                           //Without sinking
               if(j>0 &&board[i][j-1]=='X')
                   continue;
               numBattleships++;
                   
           }
       }
        return numBattleships;
    }
    
    public void sink(char[][] board,int i,int j) //Recursive solution ,Sink and proceed
    {
        if(i<0 || i>=board.length || j<0 || j>=board[i].length || board[i][j]!='X')
             return;
        
        board[i][j]='.';
        sink(board,i+1,j);
        sink(board,i-1,j);
        sink(board,i,j+1);
        sink(board,i,j-1);
    }
}