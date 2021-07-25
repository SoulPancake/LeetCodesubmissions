// https://leetcode.com/problems/count-sorted-vowel-strings

class Solution {
    public int countVowelStrings(int n) {
        int a=1,e=1,i=1,o=1,u=1;
        if(n==1)
        return a+e+i+o+u;
        for(int p=1;p<=n;p++)
        {
            u=u;
            o+=u;
            i+=o;
            e+=i;
            a+=e;
            
        }
        
        return a+e+i+o+u;
    }
}