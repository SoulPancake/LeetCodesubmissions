// https://leetcode.com/problems/rotate-array

class Solution {
    public void rotate(int[] nums, int k) {
        int i=0;
        int j=nums.length-1;
        while(i<j) //Reversing the array
        {
            int swap=nums[i];
            nums[i++]=nums[j];
            nums[j--]=swap;
        }
        
        //Now we'll reverse first k elements
        
        int a=0;
        int b=k-1; //First k elements would be from 0 to k-1th index
        
        while(a<b) //Reversing first K elements
        {
             int swap=nums[a];
            nums[a++]=nums[b];
            nums[b--]=swap;
        }
        
        int c=k;
        int d=nums.length-1;
        
        while(c<d) //Reversing the remaining elemnents!
        {
            int swap=nums[c];
            nums[c++]=nums[d];
            nums[d--]=swap;
        }
        
    }
}

//Reverse the whole array
//Reverse the first k numbers
//Reverse the remaining k numbers