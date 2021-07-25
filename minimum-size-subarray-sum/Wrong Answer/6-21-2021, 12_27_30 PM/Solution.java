// https://leetcode.com/problems/minimum-size-subarray-sum

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLength=Integer.MAX_VALUE;
        
        int left=0;
        int cumulativeSum=0;
        
        for(int i=0;i<nums.length;i++)
        {
            cumulativeSum+=nums[i];
            
            if(cumulativeSum>=target)
            {
                minLength=Math.min(minLength,i+1-left);
                cumulativeSum-=nums[left];
                left++;
            }
        }
        
        return minLength!=Integer.MAX_VALUE?minLength:0;
    }
}