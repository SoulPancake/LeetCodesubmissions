// https://leetcode.com/problems/contains-duplicate

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> Hash=new HashSet<Integer>();
        
        for(int i : nums)
        {
            if(Hash.contains(i))
                return true;
            
            Hash.add(i);
        }
        return false;
    }
}