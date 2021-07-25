// https://leetcode.com/problems/find-the-town-judge

class Solution {
    public int findJudge(int n, int[][] trust) 
    {
         int[] trustCount=new int[N+1];
        
        for(int[] i : trust)
        {
            trustCount[i[0]]--;
            trustCount[i[1]]++;
        }
        
        for(int i=1;i<=n;i++)
        {
            if(trustCount[i]==n-1)
                return i;
        }
        
        return -1;
         
    }
}