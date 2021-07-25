// https://leetcode.com/problems/remove-duplicates-from-sorted-array

void swap(int* xp, int* yp) 
{ 
    int temp = *xp; 
    *xp = *yp; 
    *yp = temp; 
} 
void selectionSort(int arr[], int n) 
{ 
    int i, j, min_idx; 
  
    // One by one move boundary of unsorted subarray 
    for (i = 0; i < n - 1; i++) { 
  
        // Find the minimum element in unsorted array 
        min_idx = i; 
        for (j = i + 1; j < n; j++) 
            if (arr[j] < arr[min_idx]) 
                min_idx = j; 
  
        // Swap the found minimum element 
        // with the first element 
        swap(&arr[min_idx], &arr[i]); 
    } 
} 

int removeDuplicates(int* nums, int numsSize){
    int a[10000]={0};
    int b[10000]={0};
    int k=0;
for(int i=0;i<numsSize;i++)
{
    if(nums[i]<0)
        b[-1*nums[i]]++;
    else
       a[nums[i]]++;
}
    for(int i=0;i<10000;i++)
    {
        if(a[i]!=0)
        {
            nums[k++]=i;
        }
        else if(b[i]!=0)
        {
            nums[k++]=-1*i;
        } 
        else
        {
            continue;
        }
    }
   selectionSort(nums,k);
    return k;
}