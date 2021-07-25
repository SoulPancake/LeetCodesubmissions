// https://leetcode.com/problems/monotonic-array

class Solution {
    public boolean isMonotonic(int[] nums) {
      int monDesc=0;
      int monAsc=0;
        
        for(int i=0;i<nums.length-1;i++)
        {
            if(nums[i]<=nums[i+1])
                monAsc++;
            if(nums[i]>=nums[i+1])
                monDesc++;
         }
        if(monAsc==nums.length-1 || monDesc==nums.length-1)
             return true;
        
        return false;
    }
}