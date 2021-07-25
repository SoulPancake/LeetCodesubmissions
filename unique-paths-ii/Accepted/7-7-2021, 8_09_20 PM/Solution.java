// https://leetcode.com/problems/unique-paths-ii

class Solution {
    public int uniquePathsWithObstacles(int[][] o) {
        if(o[0][0]==1)return 0;
        o[0][0]=1;
        for(int i=1;i<o[0].length;i++)
        {
            if(o[0][i]==1){
                o[0][i]=0;
            }else
                o[0][i]=o[0][i-1];
        }
        
        for(int i=1;i<o.length;i++)
        {
            if(o[i][0]==1){
                o[i][0]=0;
            }else
                o[i][0]=o[i-1][0];
        }
        
        for(int i=1;i<o.length;i++)
        {
            for(int j=1;j<o[0].length;j++)
            {
                if(o[i][j]==0)
                {
                    o[i][j]=o[i-1][j]+o[i][j-1];
                }else
                    o[i][j]=0;
            }
        }
        
        return o[o.length-1][o[0].length-1];
    }
}