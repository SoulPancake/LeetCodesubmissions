// https://leetcode.com/problems/plus-one



/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* plusOne(int* digits, int digitsSize, int* returnSize){
   *returnSize=digitsSize;
    if(digits[digitsSize-1]==9)
    {
        digits[digitsSize-1]=0;
        digits[digitsSize-2]++;
    }
    digits[digitsSize-1]++;
    
    return digits;
}