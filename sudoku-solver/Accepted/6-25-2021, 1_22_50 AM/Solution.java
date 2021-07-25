// https://leetcode.com/problems/sudoku-solver

class Solution {  
    boolean recurse(char[][] board, int[][] gridSet, int[] rowSet, int[] colSet, int curRow, int curCol, int ctr) {
        //success! we found a solution.
        if (ctr == 81)
            return true;
        
        //reached end of board (bottom-right corner)
        if (curRow == 8 && curCol == 9)
            return false;
        
        //roll over to next row
        if (curCol == 9)
            return recurse(board, gridSet, rowSet, colSet, curRow + 1, 0, ctr);
        
        //continue to next position
        if (board[curRow][curCol] != '.')
            return recurse(board, gridSet, rowSet, colSet, curRow, curCol + 1, ctr);
        
        for (int i = 1; i <= 9; ++i) {
            int mask = 1 << i;
            //check if setting i in current position is possible.
            if ((rowSet[curRow] & mask) > 0 || (colSet[curCol] & mask) > 0 || (gridSet[curRow/3][curCol/3] & mask) > 0)
                continue;
            
            //set number i in current position
            board[curRow][curCol] = (char) ('0' + i);
            rowSet[curRow] |= mask;
            colSet[curCol] |= mask;
            gridSet[curRow/3][curCol/3] |= mask;
            
            //if we found a solution, return immediately (otherwise board state will be undone).
            if (recurse(board, gridSet, rowSet, colSet, curRow, curCol + 1, ctr + 1))
                return true;
            
            //undo number assignment
            board[curRow][curCol] = '.';
            mask = ~mask;
            rowSet[curRow] &= mask;
            colSet[curCol] &= mask;
            gridSet[curRow/3][curCol/3] &= mask;
        }
        
        return false;
    }
    
    public void solveSudoku(char[][] board) {
        int[][] gridSet = new int[3][3];
        int[] rowSet = new int[9], colSet = new int[9];
        
        int ctr = 0;
        
        //set bits for positions already filled.
        //also, count number of positions already filled.
        for (int row = 0; row < 9; ++row) {
            for (int col = 0; col < 9; ++col) {
                if (board[row][col] == '.')
                    continue;
                int mask = 1 << (board[row][col] - '0');
                rowSet[row] |= mask;
                colSet[col] |= mask;
                gridSet[row/3][col/3] |= mask;
                ++ctr;
            }
        }
        
        recurse(board, gridSet, rowSet, colSet, 0, 0, ctr);
    }
}