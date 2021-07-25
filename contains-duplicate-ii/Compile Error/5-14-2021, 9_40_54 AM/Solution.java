// https://leetcode.com/problems/contains-duplicate-ii

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> Map=new HashMap<Integer,Integer>();
    
        for(int i=0;i<nums.length;i++)
        {
            int current=nums[i];
            if(Map.contains(current) && i-Map.get(current) <=k)
            {
                return true;
            }else
            {
                Map.put(current,i);
            }
        }
        return false;
    }
}