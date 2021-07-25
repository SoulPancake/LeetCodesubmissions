// https://leetcode.com/problems/3sum

int cmpfunc (const void * a, const void *b)
{
return ((int)a - (int)b);
}

int** threeSum(int* nums, int numsSize, int* returnSize) {
int count = 0;
int **buffer;
int start, end, i, a, b, c;

buffer = calloc( numsSize*(numsSize-1),sizeof(int *));
qsort(nums, numsSize, sizeof(int), cmpfunc);

for (i=0;i<numsSize-2;i++){
    a = nums[i];
    if(i>0 && a==nums[i-1])continue;
    start = i+1;
    end = numsSize-1;
    while (start < end) {
        b = nums[start];
        c = nums[end];
        if (a+b+c == 0){
            buffer[count] = calloc(3, sizeof(int));
            buffer[count][0]=a;
            buffer[count][1]=b;
            buffer[count][2]=c;
            count++;
         
            // Continue search for all triplet combinations summing to zero.
            while (b==nums[start+1]){
                start++;
            }
            start++;
            while (c==nums[end-1]){
                end--;
            }
            end--;
      }
      else if (a+b+c > 0) 
          end = end - 1;
      else
          start = start + 1;
      
   }
}
*returnSize=count;

return buffer;
}