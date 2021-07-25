// https://leetcode.com/problems/first-missing-positive

class Solution {
    public int firstMissingPositive(int[] nums) {
        int n=nums.length;
        
        for(int i=0;i<n;i++)
        {
            int correctPosition=nums[i]-1;
            
            while(1<=nums[i]&& nums[i]<=n && nums[i]!=nums[correctPosition])
            {
                nums[i]=nums[i]+nums[correctPosition];
                nums[correctPosition]=nums[i]-nums[correctPosition];
                nums[i]=nums[i]-nums[correctPosition];
                correctPosition=nums[i]-1;
            }
        }
        
        
        for(int i=0;i<n;i++)
        {
            if(i+1!=nums[i])
                return i+1;
        }
        
        return n+1;
    }
}