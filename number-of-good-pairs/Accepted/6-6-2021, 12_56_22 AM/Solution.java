// https://leetcode.com/problems/number-of-good-pairs

class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int res=0;
        for(int i=0;i<nums.length;i++) {
            res+=map.getOrDefault(nums[i],0);
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            }
        return res;
    }
}