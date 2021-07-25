// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        //Now attempting to do it in O(n) time and O(1) extra space
        List<Integer> Disappeared =new ArrayList<Integer>();
        
        for(int c=0;c<nums.length;c++)
        {
           int current=Math.abs(nums[c]);
            nums[current-1]=-1*Math.abs(nums[current-1]);
        }
        
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>0)
                Disappeared.add(nums[i]+1);
        }
        return Disappeared;
    }
}