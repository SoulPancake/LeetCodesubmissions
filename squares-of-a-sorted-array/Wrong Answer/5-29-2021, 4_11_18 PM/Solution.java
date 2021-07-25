// https://leetcode.com/problems/squares-of-a-sorted-array

class Solution {
    public int[] sortedSquares(int[] nums) {
        int i=0;
        int j=nums.length-1;
        int[] b=new int[nums.length];
        int k=0;
        while(i<j)
        {
            if(Math.abs(nums[i])>Math.abs(nums[j]))
                {b[k++]=nums[j]*nums[j];
                  j--;}
            else
            {
                b[k++]=nums[i]*nums[i];
                i++;
            }
        }
        return b;
    }
}