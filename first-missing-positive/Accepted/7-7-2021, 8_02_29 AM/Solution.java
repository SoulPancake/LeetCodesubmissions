// https://leetcode.com/problems/first-missing-positive

class Solution {
public int firstMissingPositive(int[] nums) {
	Arrays.sort(nums);
	var lastPositiveSeen = 1;
	for (int i = 0; i < nums.length; i++) {
		if (nums[i] <= 0 || (i > 0 && nums[i] == nums[i - 1])) // ignore non-positives and duplicates
			continue;
		if (nums[i] == lastPositiveSeen)
			lastPositiveSeen++;
		else
			break;
	}
	return lastPositiveSeen;
}
}