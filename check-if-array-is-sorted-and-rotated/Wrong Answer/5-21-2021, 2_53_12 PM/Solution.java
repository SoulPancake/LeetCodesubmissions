// https://leetcode.com/problems/check-if-array-is-sorted-and-rotated

class Solution {
    public boolean check(int[] nums) {
        
        int minIndex=0;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]<nums[minIndex])
                minIndex=i;
        }
        
        for(int i=0;i<minIndex;i++)
        {
            if(nums[i+1]<nums[i])
                return false;
        }
        for(int i=minIndex+1;i<nums.length;i++)
        {
             if(nums[i+1]<nums[i])
                return false;
        }
        
        if(nums[0]>nums[nums.length-1])
            return true;
        
        return false;
    }
}