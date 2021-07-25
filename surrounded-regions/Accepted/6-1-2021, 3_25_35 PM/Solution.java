// https://leetcode.com/problems/surrounded-regions

class Solution {
    public void solve(char[][] board) {
        //We first traverse the boundaries and whenever we encounter a O
        //We will turn the entire region with a special character * ,Like it's now a fortress
        //And it won't be captured by X
        
        for(int i=0;i<board.length;i++)
        {
            if(board[i][0]=='O')
                 dfs(board,i,0);
            if(board[i][board[i].length-1]=='O')
                 dfs(board,i,board[i].length-1);
        }
        
        for(int i=0;i<board[0].length;i++)
        {
            if(board[0][i]=='O')
                 dfs(board,0,i);
            if(board[board.length-1][i]=='O')
                 dfs(board,board.length-1,i);
        }
        
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[i].length;j++)
            {
                if(board[i][j]=='O')
                    board[i][j]='X';
                if(board[i][j]=='*')
                     board[i][j]='O';
            }
        }
    }
    
    private void dfs(char[][] board,int i,int j)
    {
        if(i<0 || i>board.length-1 || j<0 || j>board[0].length-1 || board[i][j]!='O')
             return;
        
        if(board[i][j]=='O')board[i][j]='*'; //Brick in our fortress
        
        if(i<board.length-1 && board[i+1][j]=='O')
           dfs(board,i+1,j);
        if(i>0 && board[i-1][j]=='O')
            dfs(board,i-1,j);
        if(j<board[i].length-1 && board[i][j+1]=='O')
            dfs(board,i,j+1);
        if(j>0 && board[i][j-1]=='O')
          dfs(board,i,j-1);
        return;
        
        
    }
}