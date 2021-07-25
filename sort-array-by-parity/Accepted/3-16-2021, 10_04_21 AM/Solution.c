// https://leetcode.com/problems/sort-array-by-parity



/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* sortArrayByParity(int* A, int ASize, int* returnSize){
 int *ReturnArray=(int *)malloc(ASize*sizeof(int));
    int start=0;
    int end=ASize-1;
    for(int i=0;i<ASize;i++)
    {
        if(A[i]%2==0)
        {
            ReturnArray[start++]=A[i];
        }
        else
        {
            ReturnArray[end--]=A[i];
        }
    }
    *returnSize=ASize;
    return ReturnArray;
}