// https://leetcode.com/problems/binary-number-with-alternating-bits

class Solution {
    public boolean hasAlternatingBits(int n) {
        int prev=n%10;
        n/=10;
        while(n>0)
        {
            int current=n%10;
            if(current==prev)return false;
            prev=current;
            n/=10;
        }
        return true;
    }
}