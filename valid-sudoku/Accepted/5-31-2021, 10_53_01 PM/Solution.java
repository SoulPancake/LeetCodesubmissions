// https://leetcode.com/problems/valid-sudoku

class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> seen=new HashSet<>();
        
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[i].length;j++)
            {
                if(board[i][j]!='.')
                {
                    if(!seen.add(board[i][j]+" seen in row "+i) ||
                    !seen.add(board[i][j]+" seen in column "+j) ||
                    !seen.add(board[i][j]+" seen in grid "+ i/3 +"-"+j/3))
                        return false;
                }
            }
        }
        
        return true;
    }
}