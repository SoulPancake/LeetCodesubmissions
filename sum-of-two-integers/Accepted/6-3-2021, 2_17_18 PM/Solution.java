// https://leetcode.com/problems/sum-of-two-integers

class Solution {
    public int getSum(int a, int b) {
        //a+b=c
        return (int)Math.log(Math.exp(a)*Math.exp(b));
    }
}