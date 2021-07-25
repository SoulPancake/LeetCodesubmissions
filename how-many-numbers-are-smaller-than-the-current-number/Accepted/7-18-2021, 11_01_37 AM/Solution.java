// https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        
        int[] bucket=new int[102]; //Num size to get freq
        
        for(int i : nums)
            bucket[i+1]++;
        
        for(int i=0;i<101;i++)
             bucket[i+1]+=bucket[i];
        
        for(int i=0;i<nums.length;i++)
             nums[i]=bucket[nums[i]];
        
        return nums;
        
    }
}