// https://leetcode.com/problems/rotate-array

class Solution {
    public void rotate(int[] nums, int k) {
        if(k==0)return;
        int p=nums[nums.length-1];
      
        for(int i=nums.length-1;i>0;i--)
        {
            nums[i]=nums[i-1];
        }
        nums[0]=p;
        rotate(nums,k-1);
    }
}