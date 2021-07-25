// https://leetcode.com/problems/contains-duplicate-iii

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for(int i=0;i<nums.length-1;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {if(nums[i]<0)
            {
                if(Math.abs(nums[i]-nums[j])<=t && nums[i]-nums[j]>=0)
                     return true;
            }
                if(Math.abs(nums[i]-nums[j])<=t && Math.abs(i-j)<=k)
                    return true;
            }
        }
        return false;
    }
}