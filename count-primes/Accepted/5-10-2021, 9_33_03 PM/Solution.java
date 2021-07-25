// https://leetcode.com/problems/count-primes

class Solution {
    public int countPrimes(int n) {
        //prime-> false and non-prime -> true initially assume all are primes
       boolean prime[]=new boolean[n];
        int count=0;
        for(int i=2;i<n;i++){
            if(prime[i]) continue;
            count++;
        //    System.out.println("i=  "+i);
            for(int j=2;j*i<n;j++) prime[j*i]=true;
        }
        return count;
    }
}