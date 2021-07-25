// https://leetcode.com/problems/range-sum-query-immutable

class NumArray {
    int[] internalNums;
    public NumArray(int[] nums) {
        internalNums=new int[nums.length+1];
        for(int i=1;i<=nums.length;i++){
            internalNums[i]=internalNums[i-1]+nums[i-1];
        }
    }
    
    public int sumRange(int left, int right) {
        return internalNums[right+1]-internalNums[left];
    }
}