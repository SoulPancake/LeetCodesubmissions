// https://leetcode.com/problems/search-in-rotated-sorted-array-ii

class Solution {
    public boolean search(int[] nums, int target) {
        int i = 0, l = 0, h = nums.length - 1;
        boolean found = false;
        while(l<=h){
            if(nums[l] == target){
                found = true;
                break;
            }
            else 
                l++;
            if(nums[h] == target){
                found = true;
                break;
            }
            else 
                h--;
        }
        return found; 
    }
}
