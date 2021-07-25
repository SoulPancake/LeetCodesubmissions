// https://leetcode.com/problems/range-sum-query-mutable

class NumArray {

    public NumArray(int[] nums) {
         internalNums=new int[nums.length+1];
        for(int i=1;i<=nums.length;i++){
            internalNums[i]=internalNums[i-1]+nums[i-1];//Cumulative sum
        }
    }
    
    public void update(int index, int val) {
        internalNums[index]=val;
    }
    
    public int sumRange(int left, int right) {
         return internalNums[right+1]-internalNums[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */