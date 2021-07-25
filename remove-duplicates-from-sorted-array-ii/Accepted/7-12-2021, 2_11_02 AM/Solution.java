// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii

class Solution {
    public int removeDuplicates(int[] nums) {
        int prev=nums[0];
        int count=1;
        int k=1;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]!=prev)
            {
                nums[k++]=nums[i];
                prev=nums[i];
                count=1;
            }else{
                if(count<2)
                {
                   nums[k++]=nums[i];
                   prev=nums[i];
                }
                count++;
                continue;
            }
        }
        
        return k;
    }
}