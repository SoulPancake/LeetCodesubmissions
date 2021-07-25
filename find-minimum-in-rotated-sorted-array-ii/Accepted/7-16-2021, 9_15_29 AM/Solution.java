// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii

class Solution {
    public int findMin(int[] nums) {
        int min=Integer.MAX_VALUE;
        for(int c : nums)
             min=Math.min(min,c);
        
        return min;
    }
}