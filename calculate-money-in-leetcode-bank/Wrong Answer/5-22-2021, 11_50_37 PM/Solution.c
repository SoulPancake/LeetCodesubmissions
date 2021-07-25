// https://leetcode.com/problems/calculate-money-in-leetcode-bank



int totalMoney(int n){
    int fib[n];
    fib[0]=1;
    for(int i=1;i<n;i++)
    {
        fib[i]=2*fib[i-1]+1;
    }
    return fib[n-1];
}