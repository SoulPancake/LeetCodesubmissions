// https://leetcode.com/problems/valid-perfect-square

class Solution {
    public boolean isPerfectSquare(int num) {
        int a=(int)Math.sqrt(num);
        return a*a==num;
    }
}