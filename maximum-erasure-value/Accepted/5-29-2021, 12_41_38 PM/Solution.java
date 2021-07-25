// https://leetcode.com/problems/maximum-erasure-value

class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int i = 0, j = 0, res = 0, sum = 0;
        HashSet<Integer> set=new HashSet<>();
        while(j < nums.length) {
            if(!set.contains(nums[j])) {
                sum += nums[j];
                set.add(nums[j++]);
                res = Math.max(res, sum);
            }
            else {
                sum -= nums[i];
                set.remove(nums[i++]);
            }
        }
        
        return res;
    }
}