// https://leetcode.com/problems/product-of-array-except-self

//Could you solve it in constant space??
 

class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int N=nums.length;
       // int[] leftProducts=new int [N];
       // int[] rightProducts=new int[N];
        int[] outputArray=new int[N];
        
       // leftProducts[0]=1;
        //rightProducts[nums.length-1]=1;
        
        int outputArray[0]=1;
        
        for(int i=1;i<nums.length;i++)
        {
           outputArray[i]=nums[i-1]*outputArray[i-1];
        }
        
        int R=1;
        for(int i=nums.length-1;i>=0;i--)
        {
            outputArray[i]=outputArray[i]*R;
            R=R*nums[i];
        }
        
        return outputArray;
    }
}