// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii

class Solution {
    public int findMin(int[] nums) {
	if (nums == null || nums.length == 0) return 0; 

	int left = 0, right = nums.length - 1, mid;

	while (left < right) {
		mid = (right - left) / 2 + left; 

		// linear search if all 3 boundaries are of the SAME value
		if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
			return linearSearch(nums, left, right); 
		} else if (nums[left] <= nums[mid]) {
			// left half is sorted 
			if (nums[mid] <= nums[right]) {
				// whole array is sorted 
				return nums[left]; 
			} else {
				// search right half 
				left = mid + 1; 
			}
		} else {
			// right half is sorted, search left half
			right = mid; 
		}
	}

	return nums[left]; 
}

// linear search and returns min value 
private int linearSearch(int[] nums, int left, int right) {
	int minVal = Integer.MAX_VALUE; 
	for (int i = left; i <= right; i++) {
		minVal = Math.min(nums[i], minVal);
	}
	return minVal;
}
}