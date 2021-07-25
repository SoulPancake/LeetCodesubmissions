// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array

//Using O(n) space

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        HashMap<Integer,Integer> Map=new HashMap<Integer,Integer>();
        List<Integer> Disappeared=new ArrayList<Integer>();
        for(int c:nums)
        {
            Map.put(c,1);
        }
         
        for(int c:nums.length)
        {
            if(!Map.containsKey(c))
                List.add(c);
        } 
       
        return List;
    }
}