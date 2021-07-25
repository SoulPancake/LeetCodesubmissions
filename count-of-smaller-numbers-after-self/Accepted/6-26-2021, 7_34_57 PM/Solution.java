// https://leetcode.com/problems/count-of-smaller-numbers-after-self

class Solution {
    public List<Integer> countSmaller(int[] nums) {
        
        var res = new ArrayList<Integer>(nums.length);
        var sortedList = new ArrayList<Integer>();
        
        if (nums == null || nums.length == 0)
            return res;
        
        res.add(0);
        sortedList.add(nums[nums.length-1]);
        
        for (int i = nums.length - 2; i >= 0; i--) {
            var index = Collections.binarySearch(sortedList, nums[i]);
            
            if (index >= 0) {           
                while (index > 0 && sortedList.get(index-1) == nums[i]) {
                    index--;
                }
            }
            else {
                index = -1 - index;
            }
            res.add(0, index);
            sortedList.add(index, nums[i]);
        }
        
        return res;
    }    
}