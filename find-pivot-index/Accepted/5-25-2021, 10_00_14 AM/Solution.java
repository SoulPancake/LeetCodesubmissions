// https://leetcode.com/problems/find-pivot-index

class Solution {
    public int pivotIndex(int[] nums) {
       int length = nums.length;
        int sum = 0;
        int leftSum = 0;
        for (int i=0; i<length; i++) {
            sum+=nums[i];
        }
        for (int j=0; j<length; j++) {
            if (leftSum == sum-leftSum-nums[j]) {
                return j;
            }
            leftSum += nums[j];
        }
        return -1;
    }
}