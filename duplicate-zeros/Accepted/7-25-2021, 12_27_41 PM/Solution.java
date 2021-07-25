// https://leetcode.com/problems/duplicate-zeros

class Solution {
    
    //Writes the given value in the given position, if valid.
    void writeValue(int[] arr, int value, int pos) {
        if (pos < arr.length)
            arr[pos] = value;
    }
    
    public void duplicateZeros(int[] arr) {
        int zeroCount = 0;
        
        //Count the number of zeroes.
        for (int i = 0; i < arr.length; ++i)
            if (arr[i] == 0)
                ++zeroCount;
        
        int ptr = arr.length - 1;
        while (ptr >= 0 && zeroCount > 0) {
            if (arr[ptr] != 0) {
                //The amount of 'shift' for any element is decided by the number of zeroes remaining to the left.
                writeValue(arr, arr[ptr], ptr + zeroCount);
            }
            else {
                //Same logic as above, but write two zeroes and decrement the zero count, since we have 'consumed' one zero.
                writeValue(arr, 0, ptr + zeroCount);
                writeValue(arr, 0, ptr + zeroCount - 1);
                --zeroCount;
            }
            --ptr;
        }
    }
}