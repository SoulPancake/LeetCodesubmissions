// https://leetcode.com/problems/find-the-duplicate-number

class Solution {
    public int findDuplicate(int[] nums) {
        HashMap<Integer,Integer> Map=new HashMap<>();
        
        for(int i=0;i<nums.length;i++)
        {
            Map.put(nums[i],Map.getOrDefault(nums[i],0)+1);
        }
        
        
        
        for(int i=0;i<nums.length;i++)
        {
            if(Map.get(nums[i])==2)
                return nums[i];
        }
        
        return 0;
    }
}