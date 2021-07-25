// https://leetcode.com/problems/next-greater-element-i



int* nextGreaterElement(int* nums1, int nums1Size, int* nums2, int nums2Size, int* returnSize){
    int k=0;
     *returnSize=nums1Size;
    int *b=(int *)malloc(nums1Size*sizeof(int));
      for(int i=0;i<nums1Size;i++)
      {
          int j=0;
          
          for( ;j<nums2Size && nums2[j]!=nums1[i];j++);
          for(;j<nums2Size && nums2[j]>nums2[i];j++);
          
          b[k++]= j <numsSize ? nums2[j] : -1;
          
         
      }
    return b;
}