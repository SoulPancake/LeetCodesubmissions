// https://leetcode.com/problems/surrounded-regions

class Solution {
    public void solve(char[][] board) {
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[i].length;j++)
            {
                if(board[i][j]=='O')
                    helper(board,i,j);
            }
        }
        
    }
    
    private void helper(char[][] board,int i,int j)
    {
        if(i<=0 || i>=board.length-1 || j<=0 || j>= board[i].length-1 || board[i][j]!='O')
             return;
        
        board[i][j]='X';
        
        helper(board,i+1,j);
        helper(board,i-1,j);
        helper(board,i,j+1);
        helper(board,i,j-1);
        return;
    }
}