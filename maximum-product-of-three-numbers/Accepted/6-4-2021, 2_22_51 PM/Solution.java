// https://leetcode.com/problems/maximum-product-of-three-numbers

public class Solution {
   public int maximumProduct(int[] nums) {
        int s1 = Integer.MAX_VALUE;
        int s2 = Integer.MAX_VALUE;
        int h1 = Integer.MIN_VALUE;
        int h2 = Integer.MIN_VALUE;
        int h3 = Integer.MIN_VALUE;
        for (int n : nums){
            if (n >= h1) {
                h3 = h2;
                h2 = h1;
                h1 = n;
            } else if (n >= h2) {
                h3 = h2;
                h2 = n;
            } else if (n > h3) {
                h3 = n;
            }
            
            if (n <= s1) {
                s2 = s1;
                s1 = n;
            } else if (n < s2) {
                s2 = n;
            }
        }
        return Math.max(s1 * s2 * h1, h1 * h2 * h3);
    }
    
}