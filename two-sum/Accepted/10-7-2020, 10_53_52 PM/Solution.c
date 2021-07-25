// https://leetcode.com/problems/two-sum



/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* twoSum(int* nums, int numsSize, int target, int* returnSize)
{

    int k=0;
    int *array=(int *)malloc(2*sizeof(int));
    for(int i=0;i<numsSize-1;i++)
    {
        for(int j=i+1;j<numsSize;j++)
        {
            if(nums[j]==target-nums[i])
            {
               array[k]=i;    
                array[++k]=j;
                *returnSize=2;
                return array;
            }
        }
    }
    free(array);
    *returnSize=0;
    return NULL;
}