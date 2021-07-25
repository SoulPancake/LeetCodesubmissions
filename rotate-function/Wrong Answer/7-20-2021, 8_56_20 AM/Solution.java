// https://leetcode.com/problems/rotate-function

class Solution {
    public int maxRotateFunction(int[] nums) {
        int csum=0;
        int asum=0;
        for(int i=0;i<nums.length;i++)
        {
            csum+=i*nums[i];
            asum+=nums[i];
        }
        
        int max=csum;
        
        for(int i=0;i<nums.length;i++)
        {
            csum+=csum+asum-nums.length*nums[nums.length-i-1];
            max=Math.max(max,csum);
        }
        return max;
    }
}