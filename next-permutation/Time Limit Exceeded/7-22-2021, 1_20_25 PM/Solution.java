// https://leetcode.com/problems/next-permutation

class Solution {
    public void nextPermutation(int[] nums) {
        int decreasingIndex=-1;
        for(int i=nums.length-1;i>0;i--){
            if(nums[i]>nums[i-1]){
                decreasingIndex=i-1;break;
            }
        }
        
        if(decreasingIndex==-1){
            Arrays.sort(nums);
            return;
        }
        
        int greater=nums[decreasingIndex+1];
        for(int i=decreasingIndex+2;i<nums.length;i++){
            if(nums[i]>nums[decreasingIndex]){
                greater=Math.min(greater,nums[i]);
            }
        }
        
        for(int i=decreasingIndex+1;i<nums.length;i++){
            
            if(nums[i]==greater){
                int temp=nums[i];
                nums[i]=nums[decreasingIndex];
                nums[decreasingIndex]=temp;
            }
       }
        
        
      int i=decreasingIndex+1;
      int j=nums.length-1;
        
      while(i<j){
          int temp=nums[i];
          nums[i]=nums[j];
          nums[j]=temp;
      }
        
        
        
        
    }
}