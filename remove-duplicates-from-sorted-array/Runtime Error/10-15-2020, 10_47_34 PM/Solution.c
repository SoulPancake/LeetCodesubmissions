// https://leetcode.com/problems/remove-duplicates-from-sorted-array



int removeDuplicates(int* nums, int numsSize){
    int a[10000]={0};
    
    int k=0;
for(int i=0;i<numsSize;i++)
{
    a[nums[i]]++;
}
    for(int i=0;i<10000;i++)
    {
        if(a[i]!=0)
        {
            nums[k++]=i;
        }
    }
 
    return k;
}