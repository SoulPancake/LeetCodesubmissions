// https://leetcode.com/problems/find-the-duplicate-number

class Solution {
    public int findDuplicate(int[] nums) {
        int[] freq=new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            if(freq[nums[i]]==1)
                return nums[i];
            
            freq[nums[i]]++;
        }
        
        return -1;
    }
}