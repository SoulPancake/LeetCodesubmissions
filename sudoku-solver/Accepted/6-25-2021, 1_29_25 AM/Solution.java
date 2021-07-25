// https://leetcode.com/problems/sudoku-solver

class Solution {

public void solveSudoku(char[][] board) {
    recur(board);
}

public boolean recur(char[][] board){ 
    for(int i=0;i < board.length;i++){
        for(int k=0;k < board[0].length;k++){
            if(board[i][k]=='.'){
                for(char c='1';c <= '9';c++){
                    if(isSafe(i,k,c,board)){
                        board[i][k]=c;
                        
                        if(recur(board))    return true;
                        else
                            board[i][k]='.';
                    }
                    }
                return false;
                }
            }
        }
    return true;
    }

public boolean isSafe(int row,int col,char c,char[][] board){
    for(int i=0;i < 9;i++){
        if(board[row][i]==c)    return false;
        
        if(board[i][col]==c)    return false;
        
        if(board[3*(row/3) + i/3][3*(col/3) + i%3]==c)  return false;
    }
    
    return true;
}
}