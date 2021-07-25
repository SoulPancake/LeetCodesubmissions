// https://leetcode.com/problems/sort-an-array

class Solution {
  public int[] sortArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            heapifyUp(nums, i, i + 1);
        }
        
        int size = nums.length;
        for (int i = nums.length - 1; i >= 0; i--) {
            swap(nums, i, 0);
            heapifyDown(nums, 0, i);
        }
        
        //I used min heap, you can avoid this if you use max heap
        for (int i = 0; i < nums.length / 2; i++) {
            swap(nums, i, nums.length - i - 1);
        }
        
        return nums;
    }
    
    private void heapifyUp(int[] arr, int i, int size) {
        while (hasParent(i)) {
            if (arr[i] < arr[getParent(i)]) {
                swap(arr, i, getParent(i));
                i = getParent(i);
            } else {
                break;
            }
        }
    }
    
    private void heapifyDown(int[] arr, int i, int size) {
        while (hasLeftChild(i, size)) {
            int smaller = getLeftChild(i);
            if (hasRightChild(i, size) && arr[getRightChild(i)] < arr[smaller]) {
                smaller = getRightChild(i);
            }
            if (arr[i] > arr[smaller]) {
                swap(arr, i, smaller);
                i = smaller;
            } else {
                break;
            }
        }
    }
    
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    private boolean hasLeftChild(int i, int size) {
        return 2 * i < size;
    }
    
    private boolean hasRightChild(int i, int size) {
        return (2 * i + 1) < size;
    }
    
    private boolean hasParent(int i) {
        return i / 2 >= 0;
    }
    
    private int getLeftChild(int i) {
        return (2 * i);
    }
    
    private int getRightChild(int i) {
        return (2 * i + 1);
    }
    
    private int getParent(int i) {
        return i / 2;
    }
}