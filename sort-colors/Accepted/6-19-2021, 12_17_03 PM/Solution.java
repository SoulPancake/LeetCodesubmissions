// https://leetcode.com/problems/sort-colors

class Solution {
    public void sortColors(int[] nums) {
        int k=0;
        int p=nums.length-1;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
            {
                int temp=nums[k];
                nums[k++]=nums[i];
                nums[i]=temp;
            }
                
        }
        
        for(int i=k;i<nums.length;i++)
        {
            if(nums[i]==1)
            {
                int temp=nums[k];
                nums[k++]=nums[i];
                nums[i]=temp;
            }
        }
        
    }
}