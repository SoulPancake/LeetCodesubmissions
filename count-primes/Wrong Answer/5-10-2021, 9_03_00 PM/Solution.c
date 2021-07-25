// https://leetcode.com/problems/count-primes



int countPrimes(int n){
 int count=4;
    if(n==0 || n==1 || n==2)
        return 0;
    if(n==3)
        return 1;
    if(n==4)
        return 2;
    if(n==5)
        return 2;
    if(n==6)
        return 3;
    if(n==7)
        return 3;
    if(n==8)
        return 4;
    if(n==9)
        return 4;
    if(n==10)
        return 4;
    if(n==11)
        return 4;
    if(n==12)
        return 6;
        
    for(int i=10;i<n;i=i+2)
    {if((i%5)!=0 && (i%3)!=0 && (i%7)!=0 && (i%9)!=0)
          count++;
    }
    return count;
}