// https://leetcode.com/problems/remove-duplicates-from-sorted-array

int removeDuplicates(int* nums, int numsSize)
{
    if(numsSize == 0 || numsSize == 1)
            return numsSize;
    
    int start_index = 1;
    
    for(int i = 1;i<numsSize; i++)
    {
        if(nums[i] != nums[i-1])
        {
            nums[start_index++] = nums[i];
        }
        
    }
    
    return start_index;

}