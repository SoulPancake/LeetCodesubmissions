// https://leetcode.com/problems/monotonic-array

class Solution {
    public boolean isMonotonic(int[] nums) {
        if(nums.length==1)
            return true;
        int path=0;
        if(nums.length>=2)
        {
            if(nums[1]>=nums[0])
                path=1;
            else if(nums[1]<=nums[0])
                path=2;
        }
        
        for(int i=0;i<nums.length-1;i++)
        {
            if(path==1 && nums[i]>nums[i+1])
                 return false;
            if(path==2 && nums[i]<nums[i+1])
                return false;
                          
        }
        
        return true;
    }
}