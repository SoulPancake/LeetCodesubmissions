// https://leetcode.com/problems/count-sorted-vowel-strings

class Solution {
    public int countVowelStrings(int n) {
        int a=1,e=1,i=1,o=1,u=1;
        if(n==1)
        return a+e+i+o+u;
        for(int p=1;p<=n;p++)
        {
            int tempO=o;
            o=u+o;
            int tempI=i;
            i=tempO+i;
            int tempE=e;
            e=tempI+e;
            int tempA=a;
            a=tempE+a;
            
        }
        
        return a+e+i+o+u;
    }
}