// https://leetcode.com/problems/median-of-two-sorted-arrays



double findMedianSortedArrays(int* nums1, int nums1Size, int* nums2, int nums2Size){
   return (nums1[nums1Size/2]+nums2[nums2Size/2])/2;
}