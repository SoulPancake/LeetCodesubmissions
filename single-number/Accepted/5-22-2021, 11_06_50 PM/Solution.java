// https://leetcode.com/problems/single-number

class Solution {
    public int singleNumber(int[] nums) {
        int result=0;
        for(int val : nums)
        {
            result^=val;
        }
        return result;
    }
}