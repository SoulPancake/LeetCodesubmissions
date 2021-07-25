// https://leetcode.com/problems/split-a-string-in-balanced-strings

class Solution {
    public int balancedStringSplit(String s) {
        
        int Rcount=0;
        int Lcount=0;
        int splits=0;
        for(char c: s.toCharArray())
        {
            if(Lcount==Rcount)
            {
                splits++;
                Lcount=0;
                Rcount=0;
            }
            if(c=='R')
                Rcount++;
            if(c=='L')
                Lcount++;
            
            
        }  
        return splits;
    }
}