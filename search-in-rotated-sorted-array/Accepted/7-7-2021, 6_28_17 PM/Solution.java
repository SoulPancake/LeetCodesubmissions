// https://leetcode.com/problems/search-in-rotated-sorted-array

class Solution {
    public int search(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }
    
    private int search(int[] nums, int lo, int hi, int target) {
        if (lo > hi) { // termination
            return -1;
        } else {
            int first = nums[lo];
            int last = nums[hi];

            int mid = (lo + hi) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                if (last > nums[mid]) {
                    if (target <= last) {
                        return search(nums, mid + 1, hi, target);
                    }
                    else {  // need to search in the first half as there was a rollover
                        return search(nums, lo, mid - 1, target);
                    }
                } else { // there was a rollover since the last element is smaller than the mid.
                    return search(nums, mid + 1, hi, target);
                }
            } else {             
                if (last > nums[mid]) { //second half of the array is sorted
                    return search(nums, lo, mid - 1, target);
                } else {
                    if (target <= last) { 
                        return search(nums, mid + 1, hi, target);
                    } else {
                        return search(nums, lo, mid - 1, target);
                    }
                }
            }
        }
    }
}