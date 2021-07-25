// https://leetcode.com/problems/product-of-array-except-self

class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int N=nums.length;
        int[] leftProducts=new int [N];
        int[] rightProducts=new int[N];
        int[] outputArray=new int[N];
        
        leftProducts[0]=1;
        rightProducts[nums.length-1]=1;
        
        for(int i=1;i<nums.length;i++)
        {
            leftProducts[i]=nums[i-1]*leftProducts[i-1];
        }
        for(int i=nums.length-2;i>=0;i--)
        {
            rightProducts[i]=nums[i+1]*rightProducts[i+1];
        }
        
        for(int i=0;i<nums.length;i++)
            outputArray[i]=leftProducts[i]*rightProducts[i];
        
        return outputArray;
    }
}