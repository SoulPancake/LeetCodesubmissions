// https://leetcode.com/problems/count-primes



int countPrimes(int n){
 int count=4;
    if(n==0)
        return 0;
    for(int i=10;i<n;i=i+2)
    {if((i%5)!=0 && (i%3)!=0 && (i%7)!=0 && (i%9)!=0)
          count++;
    }
    return count;
}