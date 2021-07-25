// https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side



/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* replaceElements(int* arr, int arrSize, int* returnSize){
 int *ReturnArray=(int *)malloc(arrSize*sizeof(int));
   int start=0;
    int end=returnSize-2;
    for(int i=start;i<=end;i++)
    {
        int count=0;
        int max=arr[i];
        for(int j=i+1;j<=end+1;j++)
        {
            
            if(arr[j]>arr[i])
            {
                count++;
                max=arr[j];
            }
        }
        if(count==0)
            ReturnArray[i]=-1;
        ReturnArray[i]=max;
    }
    *returnSize=arrSize;
    return ReturnArray;
}