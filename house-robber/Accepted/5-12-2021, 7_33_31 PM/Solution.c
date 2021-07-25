// https://leetcode.com/problems/house-robber


int max(int a,int b)
{
    if(a>b)
        return a;
    return b;
}

int rob(int* nums, int numsSize){
   if(numsSize==0)
       return 0;
    
    if(numsSize==1)
        return nums[0];
    
    if(numsSize==2)
        return max(nums[0],nums[1]);
    
    int *dp=(int *)malloc(numsSize*sizeof(int));
    
    dp[0]=nums[0];
    dp[1]=max(nums[0],nums[1]);
    for(int i=2;i<numsSize;i++)
    {
        dp[i]=max(nums[i]+dp[i-2],dp[i-1]);
    }
    
    return dp[numsSize-1];
}