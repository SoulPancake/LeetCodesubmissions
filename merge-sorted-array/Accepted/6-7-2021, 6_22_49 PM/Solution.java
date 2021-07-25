// https://leetcode.com/problems/merge-sorted-array

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=0;
        int j=0;
        int[] e=new int[m+n];
        int k=0;
        while(i<m && j<n)
        {
            if(nums1[i]>nums2[j])
            {
                e[k++]=nums2[j++];
            }else
                e[k++]=nums1[i++];
        }
        
        if(i==m && j==n)
            { for(int b=0;b<m+n;b++)
                 nums1[b]=e[b];return;}
        else if(i==m)
        {
            for(int p=j;p<n;p++)
                e[k++]=nums2[p];
        }else
        {
            for(int p=i;p<m;p++)
                e[k++]=nums1[p];
        }
        
        for(int b=0;b<m+n;b++)
            nums1[b]=e[b];return;
        
      
    }
}