// https://leetcode.com/problems/single-number-ii

class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        
        if(nums.length==1)
             return nums[0];
        if(nums.length>=2)
        {
            if(nums[0]!=nums[1])
                return nums[0]; //First number is singlet
        }
        if(nums.length>1)
        {
            if(nums[nums.length-1]!=nums[nums.length-2])
               return nums[nums.length-1]; //Last number is singlet 
        }
        for(int i=1;i<nums.length;)
        {
            if(nums[i-1]==nums[i])
                 i+=3;
            else
                return nums[i-1];
        }
        
        return -1;
        
    }
}