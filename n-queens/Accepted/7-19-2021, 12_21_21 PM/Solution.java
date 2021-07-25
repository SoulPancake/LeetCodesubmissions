// https://leetcode.com/problems/n-queens

class Solution {
    
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        result=new ArrayList<>();
        char[][] matrix=new char[n][n];
        for(char[] a : matrix)
        {
            Arrays.fill(a,'.');
        }
        
        magicFunction(0,n,matrix);
        return result;
    }
    
    
    private void magicFunction(int row,int n,char[][] matrix)
    {
        if(row==n){
            List<String> s=makeList(matrix);
            result.add(s);
            return;
        }else{
            for(int i=0;i<n;i++)
            {
                if(isValid(row,i,n,matrix)){
                    matrix[row][i]='Q';
                    magicFunction(row+1,n,matrix);
                    matrix[row][i]='.';
                }
            }
        }
    }
    
     boolean isValid(int row,int col,int n,char[][] matrix)
    {
        //checking row wise
        for(int i=0;i<row;i++)
        {
            if(matrix[i][col] == 'Q')
                return false;
        }
        int i = row,j=col;
        while(i>=0 && j>=0)
        {
            if(matrix[i][j] == 'Q')
                return false;
            i--;j--;
        }
        i=row;j=col;
        while(i>=0 && j<n)
        {
            if(matrix[i][j] == 'Q')
                return false;
            i--;j++;
        }
        return true;
    }
    
    
    List<String> makeList(char[][] matrix)
    {
        List<String> list = new ArrayList<>();
        for(char[] array : matrix)
            list.add(String.valueOf(array));
        return list;
    }
}