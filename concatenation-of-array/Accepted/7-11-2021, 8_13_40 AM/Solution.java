// https://leetcode.com/problems/concatenation-of-array

class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] n=new int[2*nums.length];
        int k=0;
        for(int i=0;i<nums.length;i++)
              { n[i]=nums[i];k=i+1;}
        
        for(int i=nums.length;i<2*nums.length;i++)
             n[k++]=nums[i-nums.length];
//         int k=0;
//         while(k<nums.length)
//             n[k++]=nums[k++];
        
//         int p=0;
//         while(p<(nums.length))
//             n[k++]=nums[p++];
        
//         return n;
        
        return n;
    }
}