// https://leetcode.com/problems/find-pivot-index

class Solution 
{
    public int pivotIndex(int[] nums) 
    {
      int TotalSum=0;
        int leftSum=0;
        
        for(int i=0;i<nums.length;i++)
            TotalSum+=nums[i];
        
        for(int i=0;i<nums.length;i++)
        {
            if(leftSum==TotalSum-leftSum-nums[i])
                 return i;
            
            leftSum+=nums[i];
        }
        
        return -1;
    }
}