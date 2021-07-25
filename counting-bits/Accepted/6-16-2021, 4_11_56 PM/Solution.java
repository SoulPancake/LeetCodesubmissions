// https://leetcode.com/problems/counting-bits

class Solution {
    public int[] countBits(int n) {
        int iter =0, i=0,j=1;
    int[] res = new int[n+1];
    
    for(i=0;i<=n;i++) {
        if(i==0)
            res[i]=0;
        else if(i==1)
            res[i]=1;
        
        else {
            if(iter==2) {
                j++;
                iter=0;
            }
            res[i]=res[j]+iter;
            iter++;
        }
    }
    return res;
    }
}