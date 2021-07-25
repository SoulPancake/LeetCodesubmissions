// https://leetcode.com/problems/count-primes

class Solution {
    public int countPrimes(int n) {
        boolean prime [] = new boolean [n];
        Arrays.fill (prime, true);
        for (int i = 2; i*i < n; i++) {
            if (prime [i]) { 
				// Update all multiples of i to false if i is prime
                for (int j = i * i; j < n; j += i)
                    prime [j] = false;
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (prime [i])
                count++;
        }
        return count;
    }
}