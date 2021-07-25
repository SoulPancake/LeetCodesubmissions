// https://leetcode.com/problems/maximum-subarray

class Solution {
    public int maxSubArray(int[] nums) {
        int mx=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i-1]>0)
                nums[i]+=nums[i-1];
            mx=Math.max(mx,nums[i]);
        }
        return mx;
    }
}