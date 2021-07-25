// https://leetcode.com/problems/counting-bits

class Solution {
    public int[] countBits(int n) {
       
    int[] res = new int[n+1];
    
    for(int i=0;i<=n;i++) {
        if(i==0)
           { res[i]=0;continue;}
        else if(i==1)
            {res[i]=1;continue;}
        else {
            if(i%2==0)
                res[i]=res[i>>1];
            else
                res[i]=res[i>>1]+1;
        }
    }
    return res;
    }
}