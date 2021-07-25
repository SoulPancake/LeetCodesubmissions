// https://leetcode.com/problems/array-partition-i

class Solution {
    public int arrayPairSum(int[] nums) {
      Arrays.sort(nums);
        
        //If you sort it and go from zeroth index skipping by 2
        //Then you automatically get the min value every time
        //So no need to call the Math.min( ) function
        int sum=0;
//         for(int i=nums.length-1;i>0;i-=2)
//         {
//             sum+=Math.min(nums[i],nums[i-1]);
//         }
            
        for(int i=0;i<nums.length-1;i+=2)
            sum+=nums[i];
        return sum;
    }
}