// https://leetcode.com/problems/shuffle-the-array

class Solution {
    public int[] shuffle(int[] nums, int n) {
         int[] a=new int[2*n];
        int k=0;
        for(int i=0;i<2*n;i=i+2)
        {
            a[i]=nums[k++];
        }
        
        k=n;
        for(int i=1;i<2*n;i=i+2)
        {
            a[i]=nums[k++];
        }
        
        return a;
    }
}