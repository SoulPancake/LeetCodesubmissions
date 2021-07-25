// https://leetcode.com/problems/search-insert-position



int searchInsert(int* nums, int numsSize, int target){
    int diff[numsSize];
    for(int i=0;i<numsSize;i++)
        diff[i]=0;
    for(int i=0;i<numsSize;i++)
{
    if(nums[i]==target)
        return i;
    else
      {
        diff[i]=target-nums[i];  
      }
}
    int position;
    int min=diff[0];
    for(int j=0;j<numsSize;j++)
    {
        if(min>diff[j])
          min=diff[j];position=j;
    }
    return position;
}