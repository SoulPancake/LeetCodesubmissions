// https://leetcode.com/problems/minimum-xor-sum-of-two-arrays

class Solution {
    public int minimumXORSum(int[] nums1, int[] nums2) {
    int sum=0;
        for(int i=0;i<nums1.length;i++)
        {int min=nums1[i]^nums2[i];
            for(int j=1;j<nums2.length;j++)
            {  if(nums2[j]>=0)
                 min=Math.min(nums1[i]^nums2[j],min);
            }
            for(int j=0;j<nums2.length;j++)
            {
                if(min==(nums1[i]^nums2[j]))
                    nums2[j]=-1;
            }
         sum+=min;
        }
        
        return sum;
    }
}