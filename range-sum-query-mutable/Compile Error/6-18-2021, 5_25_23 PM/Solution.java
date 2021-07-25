// https://leetcode.com/problems/range-sum-query-mutable

class NumArray {
    int[] internalNums;
    public NumArray(int[] nums) {
        internalNums=new int[nums.length+1];
        for(int i=1;i<=nums.length;i++){
            internalNums[i]=internalNums[i-1]+nums[i-1];//Cumulative sum
        }
    }
    
    public int sumRange(int left, int right) {
        return internalNums[right+1]-internalNums[left];
    }
    //Right +1 cumulative sum gives sum upto the previous element and left gives the sum till the left-1th index
    //So the difference would give us the sum within the range
}