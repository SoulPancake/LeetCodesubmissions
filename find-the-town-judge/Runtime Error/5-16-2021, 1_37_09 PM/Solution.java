// https://leetcode.com/problems/find-the-town-judge

class Solution {
    public int findJudge(int n, int[][] trust) {
        int townJudge=0;
        //N is the number of total people
        //So Town judge is trusted by everyone except himself
        //So N-1 values must exist for a certain j (a[i][j])
        
        int freq[]=new int[trust.length];
        
        for(int i=0;i<trust.length;i++)
        {
         
            for(int j=0;j<trust[i].length;j++)
            {
               freq[trust[i][1]]++;
            }
        }
        
        
        for(int i=0;i<freq.length;i++)
        {
            if(freq[i]==n-1)
                return i;
        }
        
        return -1;
    }
}