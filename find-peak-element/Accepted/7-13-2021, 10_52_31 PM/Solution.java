// https://leetcode.com/problems/find-peak-element

class Solution {
    public int findPeakElement(int[] nums) {
        int peakIndex=-1;
        if(nums.length==1)return 0;
        if(nums[1]<nums[0])return 0;
        for(int i=1;i<nums.length-1;i++)
        {
            if(nums[i+1]<nums[i] && nums[i]>nums[i-1])
                 {peakIndex=i;break;}
        }
        if(nums[nums.length-1]>nums[nums.length-2])return nums.length-1;
        return peakIndex;
        
    }
}