// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array

//Using O(n) space

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
    /*    //I don't need a HashMap I could've just used a hashset
        HashMap<Integer,Integer> Map=new HashMap<Integer,Integer>(); //The default value for int is 0 that is why this works
        
        //The default value for booleans is false
      */
        
        HashSet<Integer> Map=new HashSet<Integer>(); //Need no mapping
        List<Integer> Disappeared=new ArrayList<Integer>();
        for(int c:nums)
        {
            Map.add(c);
        }
         
        for(int c=1;c<=nums.length;c++)
        {
            if(!Map.contains(c))
                Disappeared.add(c);
        } 
       
        return Disappeared;
    }
}