// https://leetcode.com/problems/divide-two-integers

class Solution {
     
    public int divide(int dividend, int divisor) {
        int count=0;
        if(dividend-divisor <= 0)
            return count;
        
        dividend-=divisor;
        count++;
        return divide(dividend,divisor);
    }
}