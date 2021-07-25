// https://leetcode.com/problems/find-the-duplicate-number

class Solution {
    public int findDuplicate(int[] nums) {
        int[] freq=new int[nums];
        
        for(int i=0;i<nums.length;i++)
        {
            if(freq[nums[i]]>=2)
                return nums[i];
            freq[nums[i]]++;
            
        }
        
        
        
     
        
        return 0;
    }
}