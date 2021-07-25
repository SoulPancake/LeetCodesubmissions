// https://leetcode.com/problems/divide-two-integers

class Solution {
     
    public int divide(int dividend, int divisor) {
        int count=0;
       while(dividend-divisor>0)
       {
           dividend-=divisor;
           count++;
       }
           
        return count;
    }
}