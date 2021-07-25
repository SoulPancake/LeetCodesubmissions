// https://leetcode.com/problems/minimize-maximum-pair-sum-in-array

class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        
        int max=0;
        int i=0;
        int j=nums.length-1;
        
        while(i<=j)
        {
            int sum=nums[i]+nums[j];
            max=Math.max(sum,max);
            i++;
            j--;
        }
        
        return max;
    }
}