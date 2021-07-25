// https://leetcode.com/problems/jump-game-vi




class Solution {
    public int maxResult(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int len = nums.length;
        int [] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = nums[0];
        for (int i = 0; i < len; i++) {
            int step = 1;
            while (step <= k && step + i < len) {
                dp[i + step] = Math.max(dp[i + step], dp[i] + nums[i + step]);
                if (nums[i + step] >= 0) {
                    break;
				};
                step++;
            }
        }

        return dp[nums.length-1];
    }
}