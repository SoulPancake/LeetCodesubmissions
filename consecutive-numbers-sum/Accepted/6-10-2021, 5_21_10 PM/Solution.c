// https://leetcode.com/problems/consecutive-numbers-sum

int consecutiveNumbersSum(int n){
    int res=0;
    
    for (int k=1, s=0; (s+=k)<=n; k++) res += !(n%k-(((k&1)-1)&(k>>1)));
    
    return res;
}