// https://leetcode.com/problems/single-number


//Take XOR of all the elements
int singleNumber(int* nums, int numsSize){
   int xor=0;
    for(int i=0;i<numsSize;i++)
    {
        xor=nums[i]^xor;
    }               //Any number XORd with 0 is that number
    
    
    return xor;
    
}