// https://leetcode.com/problems/running-sum-of-1d-array

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* runningSum(int* nums, int numsSize, int* returnSize){
   int *bopas=(int *)malloc(numsSize*sizeof(int));
    int i;
    bopas[i]=0;
    bopas[i]=bopas[i]+nums[i];

    
    for(int i=1;i<numsSize;i++)
    bopas[i]=bopas[i-1]+nums[i];
    
    *returnSize=numsSize;
    return bopas;
}