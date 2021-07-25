// https://leetcode.com/problems/find-all-duplicates-in-an-array

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        
        List<Integer> l=new ArrayList<>();
        
        for(int i=1;i<nums.length;i++)
        {
            if((nums[Math.abs(nums[i])-1])<0)
                l.add(Math.abs(nums[i]));
            
            nums[Math.abs(nums[i])-1]*=-1;
        }
       
        
        return l;
    }       
}