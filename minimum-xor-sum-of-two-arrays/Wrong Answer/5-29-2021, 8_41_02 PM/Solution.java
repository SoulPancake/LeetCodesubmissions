// https://leetcode.com/problems/minimum-xor-sum-of-two-arrays

class Solution {
    public int minimumXORSum(int[] nums1, int[] nums2) {
    
        Arrays.sort(nums2);
        int[] num=new int[nums2.length];
        for(int i=0;i<nums2.length;i++)
        {
            num[nums2.length-1-i]=nums2[i];
        }
        int sum=0;
        for(int i=0;i<nums1.length;i++)
            sum+=nums1[i]^num[i];
        
        return sum;
    }
}