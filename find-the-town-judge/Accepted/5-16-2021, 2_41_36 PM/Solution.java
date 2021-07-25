// https://leetcode.com/problems/find-the-town-judge

class Solution {
    public int findJudge(int n, int[][] trust) 
    {
         int[] trustCount=new int[n+1];
        
        for(int[] i : trust)
        {
            trustCount[i[0]]--;
            trustCount[i[1]]++;
        }
        
        for(int i=1;i<=n;i++)
        {
            if(trustCount[i]==n-1) //That dude trusts no one but trusted by everyone
                return i;          //So For him trust count will never decrement (line 8)
        }
        
        return -1;
         
    }
}