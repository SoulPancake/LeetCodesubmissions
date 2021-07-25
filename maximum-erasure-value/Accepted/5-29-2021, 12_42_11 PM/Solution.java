// https://leetcode.com/problems/maximum-erasure-value

class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int[] hash = new int[10001];
        int r = 0, len = nums.length, l = 0, max = 0, sum = 0, cnt = 0;
        while(r < len) {
            sum += nums[r];
			// cnt > 0 means some number is duplicated
            if(hash[nums[r++]]++ >= 1) cnt++;
            while(cnt > 0) {
				// find the leftmost index that no duplicated numbers betwen [l, r]
                sum -= nums[l];
                if(hash[nums[l++]]-- == 2) cnt--;                
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}