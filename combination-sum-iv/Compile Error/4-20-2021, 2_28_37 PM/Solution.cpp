// https://leetcode.com/problems/combination-sum-iv

class Solution {
public:
    int combinationSum4(vector<int>& nums, int target) {
         if (nums.length == 1 && nums[0] != target)
            return 0;
        int [] dp = new int [target + 1];//Dynamic programming
        for (int i=1; i<=target; i++) {
            for (int number : nums) {
                if (i == number) {
                    dp[i] += 1;
                }
                else if (i - number > 0) {
                    dp[i] += dp[i - number];
                }
            }
        }
        return dp[target];
    }
};