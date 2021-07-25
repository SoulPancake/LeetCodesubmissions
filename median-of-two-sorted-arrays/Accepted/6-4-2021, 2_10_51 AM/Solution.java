// https://leetcode.com/problems/median-of-two-sorted-arrays

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums=new int[nums1.length+nums2.length];
        
        int i=0;
        int j=0;
        int k=0;
        while(i<nums1.length && j<nums2.length)
        {
            if(nums1[i]<=nums2[j])
            {
                nums[k++]=nums1[i];
                i++;
            }else
            {
                nums[k++]=nums2[j];
                j++;
            }
        }
        
        if(i==nums1.length && j==nums2.length)
        {
            //Do nothing
        }
        else if(i==nums1.length)
        {
            for(int p=j;p<nums2.length;p++)
                nums[k++]=nums2[p];
        }else{
            for(int p=i;p<nums1.length;p++)
                nums[k++]=nums1[p];
        }
        
        int l=nums1.length+nums2.length;
        
        if(l%2==0)
        {
            return (double)(((double)nums[l/2]+(double)nums[(l/2)-1])/2);
        }
        
        
        return (double)nums[(nums1.length+nums2.length)/2];
    }
}