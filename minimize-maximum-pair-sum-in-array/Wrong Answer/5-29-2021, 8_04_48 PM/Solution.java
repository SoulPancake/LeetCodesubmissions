// https://leetcode.com/problems/minimize-maximum-pair-sum-in-array

class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        
        int max=0;
        for(int i=nums.length-1;i>0;)
        {
            int sum=nums[i]+nums[i-1];
            max=Math.max(sum,max);
            
            if(nums[i]==nums[i-1])
                 i-=2;
            else
                i--;
        }
        
        return max;
    }
}