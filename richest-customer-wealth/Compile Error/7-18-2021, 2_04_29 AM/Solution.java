// https://leetcode.com/problems/richest-customer-wealth

class Solution {
    public int maximumWealth(int[][] accounts) {
        int max=Integer.MIN_VALUE;
        for(int[] a: accounts)
        { int sum=0;
            for(int c : a)
                sum+=a;
            max=Math.max(max,sum);
        }
        
        return max;
    }
}