// https://leetcode.com/problems/plus-one



/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* plusOne(int* digits, int digitsSize, int* returnSize){
   *returnSize=digitsSize;
    
    digits[digitsSize-1]++;
    
    return digits;
}