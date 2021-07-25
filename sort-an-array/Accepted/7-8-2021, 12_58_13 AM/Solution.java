// https://leetcode.com/problems/sort-an-array

class Solution {
    public int[] sortArray(int[] nums) {
        Arrays.parallelSort(nums);
        return nums;
    }
}