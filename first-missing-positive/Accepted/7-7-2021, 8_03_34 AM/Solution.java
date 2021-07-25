// https://leetcode.com/problems/first-missing-positive

class Solution {
public int firstMissingPositive(int[] nums) {
	var max = Integer.MIN_VALUE;
	var set = new HashSet<Integer>();
	for (var num : nums) {
		set.add(num);
		max = Math.max(max, num);
	}
	if (max < 1)
		return 1;
	for (var i = 1; i <= max; i++)
		if (!set.contains(i))
			return i;
	return max + 1;
}
}