// https://leetcode.com/problems/counting-bits

class Solution {
    public int[] countBits(int num) {
        int sum[] = new int[num+1];
        for(int i = 0; i<=num; i++) {
            sum[i] = getBits(i);
        }
        
        return sum;
        
    }
    // Method to get bits for each digit
    /* Apporach: Bitwise and between n and n-1 converts the least significant bit to 0.
	*  So if there is 1 present in binary, it will be converted into 0. We can use this method  recursively  to find all 1's.  
	*/
    private int getBits(int n) {
        int ans = 0 ;
        while(n != 0) {
            ans ++;
            n = n & (n-1);
        }
        return ans;
    }
}