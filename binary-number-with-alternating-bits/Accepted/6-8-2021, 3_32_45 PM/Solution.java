// https://leetcode.com/problems/binary-number-with-alternating-bits

class Solution {
    public boolean hasAlternatingBits(int n) {
        int prev=n%2;
        n/=2;
        while(n>0)
        {
            int current=n%2;
            if(current==prev)return false;
            prev=current;
            n/=2;
        }
        return true;
    }
}