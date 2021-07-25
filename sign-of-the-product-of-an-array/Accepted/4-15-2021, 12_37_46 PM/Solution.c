// https://leetcode.com/problems/sign-of-the-product-of-an-array



int arraySign(int* nums, int numsSize){
    int sign=0;
   for(int i=0;i<numsSize;i++)
   {
       if(nums[i]<0)
       {
           sign=(sign+1)%2;
       }
       if(nums[i]==0)
       {
           return 0;
       }
   }
    if(sign==0)
        return 1;
    else 
        return -1;
}