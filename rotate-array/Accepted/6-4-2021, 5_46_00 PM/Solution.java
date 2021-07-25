// https://leetcode.com/problems/rotate-array

class Solution {
    public void rotate(int[] nums, int k) {
        if(nums.length==1 || k==0) return;
        k%=nums.length; //very important warna gol gol duniya ho jayega
    
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
        
    }
    
    private void reverse(int[] nums,int a,int b)
    {
         while(a<b) //Reversing first K elements
        {
             nums[a]=nums[a]+nums[b];
            nums[b]=nums[a]-nums[b];
            nums[a]=nums[a]-nums[b];
             a++;
             b--;
        }
    }
}

//Reverse the whole array
//Reverse the first k numbers
//Reverse the remaining k numbers