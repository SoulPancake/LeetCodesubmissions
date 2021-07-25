// https://leetcode.com/problems/minimum-xor-sum-of-two-arrays

class Solution {
    public int minimumXORSum(int[] nums1, int[] nums2) {
    Arrays.parallelSort(nums2);
        for(int i=0;i<nums2.length/2;i++)
        {
            int swap=nums2[i];
            nums2[i]=nums2[nums2.length-1-i];
            nums2[nums2.length-1-i]=swap;
            
        }
        
        int sum=0;
        for(int i=0;i<nums1.length;i++)
            sum+=nums1[i]^nums2[i];
        
        return sum;
        
    }
}