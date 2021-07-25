// https://leetcode.com/problems/first-missing-positive

class Solution {
public int firstMissingPositive(int[] nums) {
	var n = nums.length;
	for (var i = 0; i < nums.length; i++)
		//  put positives in their right place as long as possible
		while (0 <= nums[i] - 1 && nums[i] - 1 < n && nums[i] != nums[nums[i] - 1]) 
			swap(nums, nums[i] - 1, i);

	// scan for first missing positive
	for (var i = 0; i < n; i++)
		if (nums[i] != i + 1)
			return i + 1;
	return n + 1;
}

private void swap(int[] nums, int i, int j) {
	var temp = nums[i];
	nums[i] = nums[j];
	nums[j] = temp;
}
}