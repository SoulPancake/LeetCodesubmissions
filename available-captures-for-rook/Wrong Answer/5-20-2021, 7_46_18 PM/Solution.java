// https://leetcode.com/problems/available-captures-for-rook

class Solution {
    int number;
    public int numRookCaptures(char[][] board) {
        
        number=0;
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[i].length;j++)
            {
                if(board[i][j]=='R')
                {
                   return number(board,i,j);
                }
            }
        }
        
        return -1;
    }
    
    public int number(char[][] board,int i,int j)
    {
        for(int start=i;start<board.length;start++)
        {
            if(board[start][j]=='B')
                break;
            
            if(board[start][j]=='p')
            {
                number++;
            }
        }
        
         for(int start=i;start>=0;start--)
        {
            if(board[start][j]=='B')
                break;
            
            if(board[start][j]=='p')
            {
                number++;
            }
        }
        
        for(int start=j;start>=0;start--)
        {
            if(board[i][start]=='B')
                break;
            
            if(board[i][start]=='p')
            {
                number++;
            }
        }
         for(int start=j;start<board[0].length;start++)
        {
            if(board[i][start]=='B')
                break;
            
            if(board[i][start]=='p')
            {
                number++;
            }
        }
        
        return number;
        
    }
}
