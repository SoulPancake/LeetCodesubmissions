// https://leetcode.com/problems/third-maximum-number

class Solution {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        
        if(nums.length-3<0)
            return nums[nums.length-1];
        else
            return nums[nums.length-3];
    }
}