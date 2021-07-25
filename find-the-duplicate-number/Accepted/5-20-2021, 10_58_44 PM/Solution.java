// https://leetcode.com/problems/find-the-duplicate-number

class Solution {
    public int findDuplicate(int[] nums) {
        if(nums.length==0)
            return 0;
        
        Arrays.sort(nums);
        
        for(int i=0;i<nums.length-1;i++)
        {
            if(nums[i+1]==nums[i])
                return nums[i];
        }
        
        return -1;
    }
}