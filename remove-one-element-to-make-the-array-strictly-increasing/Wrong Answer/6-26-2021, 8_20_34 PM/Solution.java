// https://leetcode.com/problems/remove-one-element-to-make-the-array-strictly-increasing

class Solution {
    public boolean canBeIncreasing(int[] nums) {
      
        int[] boma=nums;
        Arrays.sort(nums);
        
        int count=0;
        for(int i=0;i<nums.length;i++)
            if(nums[i]!=boma[i])
                count++;
        
        return count<=2;
}
}