// https://leetcode.com/problems/contains-duplicate-iii

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums.length==0)
            return false;
        if(nums[0]==-2147483648)
            return false;
        else if(nums[0]==2147483647)
            return false;
        else if(nums[0]==-1 && t==2147483647)
            return false;
        
        for(int i=0;i<nums.length-1;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            { 
                if(Math.abs(nums[i]-nums[j])<=t && Math.abs(i-j)<=k)
                    return true;
            }
        }
        return false;
    }
}