// https://leetcode.com/problems/available-captures-for-rook

class Solution {
    public int numRookCaptures(char[][] board) {
        
        int row = 0;
        int col = 0;

        boolean found = false;
        for(int i=0;i<8;i++)
        {
            for(int j=0;j<8;j++)
            {
                if(board[i][j] == 'R')
                {
                    row = i;
                    found = true;
                    col = j;
                    break;
                    
                }
            }
            if(found)
                break;
        }
        
        int result = 0;
        int count = 0;
        
        //Along the row.
        boolean left = true;
        for(int i=0;i<8;i++)
        {
            if(left)
            {
                if(board[row][i] == 'p')
                    count++;
                else if(board[row][i] == 'B')
                    count = 0; //Reset.
            }
            
            if(board[row][i] == 'R')
            {
                if(count>0)
                    result = result + 1;
                left = false;
                count = 0;
            }
            
            if(!left)
            {
                if(board[row][i] == 'B')
                    break;
                else if(board[row][i] == 'p')
                {
                    result++;
                    break;
                }
            }
        }
        
        
        //Along the column.
        count = 0;
        boolean up = true;
        for(int i=0;i<8;i++)
        {
            if(up)
            {
                if(board[i][col] == 'p')
                    count++;
                else if(board[i][col] == 'B')
                    count = 0; //Reset.
            }
            
            if(board[i][col] == 'R')
            {
                if(count>0)
                    result = result + 1;
                up = false;
                count = 0;
            }
            
            if(!up)
            {
                if(board[i][col] == 'B')
                    break;
                else if(board[i][col] == 'p')
                {
                    result++;
                    break;
                }
            }
        }
        return result;
    }
}