// https://leetcode.com/problems/majority-element

class Solution {
    public int majorityElement(int[] nums) {
        if(nums.length==1)
            return nums[0];
        HashMap<Integer,Integer> Map=new HashMap<Integer,Integer>();
        
        for(int i : nums)
        {
            if(Map.containsKey(i) && (Map.get(i)+1)>(nums.length/2))
            {
                return i;
            }else
                Map.put(i,Map.getOrDefault(i,0)+1);
        }
        
        return -1;
        } 
}