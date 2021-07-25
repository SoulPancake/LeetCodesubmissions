// https://leetcode.com/problems/sudoku-solver

class Solution {
   // optimised
    int[] row = new int[9];
    int[] col = new int[9];
    int[][] mat = new int[3][3];
    
    public boolean solveSudoku_02(char[][] board, ArrayList<Integer> emptyIndex, int idx) {
        if (idx == emptyIndex.size()) {
            return true;
        }

        int oneDEncodedValue = emptyIndex.get(idx); // emptyIndex[idx];
        int r = oneDEncodedValue / 9;
        int c = oneDEncodedValue % 9;

        for (int num = 1; num <= 9; num++) {
            int mask = 1 << num;
            if ((row[r] & mask) == 0 && (col[c] & mask) == 0 && (mat[r / 3][c / 3] & mask) == 0) {
                row[r] ^= mask;
                col[c] ^= mask;
                mat[r / 3][c / 3] ^= mask;

                board[r][c] = (char) (num + '0');
                if (solveSudoku_02(board, emptyIndex, idx + 1))
                    return true;
                board[r][c] = '.';

                row[r] ^= mask;
                col[c] ^= mask;
                mat[r / 3][c / 3] ^= mask;

            }
        }

        return false;
    }

    public void solveSudoku(char[][] board) {
        ArrayList<Integer> emptyIndex = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    emptyIndex.add(i * 9 + j); // emptyIndex.push_back(i * 9 + j);
                else {
                    int mask = 1 << (board[i][j] - '0');
                    row[i] ^= mask;
                    col[j] ^= mask;
                    mat[i / 3][j / 3] ^= mask;
                }
            }
        }

        solveSudoku_02(board, emptyIndex, 0);
    }
}