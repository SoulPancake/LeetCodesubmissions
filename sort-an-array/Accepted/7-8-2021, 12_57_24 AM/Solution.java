// https://leetcode.com/problems/sort-an-array

class Solution {
    public int[] sortArray(int[] nums) {
        return quickSort(nums);
    }
    
    private int[] quickSort(int[] nums) {
        if (nums.length <= 1) return nums;
        this.qHelper(nums, 0, nums.length - 1);
        return nums;
    }
    private void qHelper(int[] nums, int head, int tail) {
        if (head >= tail) return;
        int pivot = this.partition(nums, head, tail);
        this.qHelper(nums, head, pivot-1);
        this.qHelper(nums, pivot+1, tail);
    }
    
    private int partition(int[] nums, int head, int tail) {
        // use the index of medium value as pivot point!!!
        int pivot_index = this.getMediumValueIndex(nums, head, tail);
        int pivot = nums[pivot_index];
        // int temp = nums[pivot_index];
        nums[pivot_index] = nums[tail];
        nums[tail] = pivot;
        pivot_index = tail;
        int i = head - 1;
        for (int j = head; j < tail; ++j) {
            if (nums[j] < pivot) {
                ++i;
                //swap i and j
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        // swap i+1 and pivot_index
        int temp = nums[i+1];
        nums[i+1] = nums[pivot_index];
        nums[pivot_index] = temp;
        return i+1;
    }
    
    private int getMediumValueIndex(int[] nums, int head, int tail) {
        int mid = head + (tail - head) / 2;
        int l = nums[head];
        int m = nums[mid];
        int r = nums[tail];
        if (l > m) {
            // l > m > r
            if (m > r) return mid;
            // r > l > m
            else if (r > l) return head;
            //l > r > m
            else return tail;
        } 
        // m > l
        else {
            // r > m > l
            if (r > m) return mid;
            // m > l > r
            else if (l > r) return head;
            // m > r > l
            else return tail;
        }
    }
}