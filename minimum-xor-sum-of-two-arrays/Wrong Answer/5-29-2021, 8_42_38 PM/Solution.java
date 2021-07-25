// https://leetcode.com/problems/minimum-xor-sum-of-two-arrays

class Solution {
    public int minimumXORSum(int[] nums1, int[] nums2) {
    
        Arrays.sort(nums2);
        
        int sum=0;
        for(int i=0;i<nums1.length;i++)
            sum+=nums2[nums1.length-1-i]^nums1[i];
        
        return sum;
    }
}