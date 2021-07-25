// https://leetcode.com/problems/remove-duplicates-from-sorted-array



int removeDuplicates(int* nums, int numsSize){
  int unique=0;
    int k=0;
    int uniqueNumber;
    for(int i=0;i<numsSize;i++)
    {
        if(nums[i]!=uniqueNumber)
        {
            uniqueNumber=nums[i];
            unique++;
            nums[k++]=nums[i];
        }else
        {
            continue;
        }
    }
    return unique;
    
}