// https://leetcode.com/problems/maximum-erasure-value

class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int i = -1;
        int j = -1;
        int max = Integer.MIN_VALUE;
        int currSum = 0;
        HashSet<Integer> set = new HashSet();
        while(true){
            boolean f1 = false;
            boolean f2 = false;
            while(i<nums.length-1&&!set.contains(nums[i+1])){ // acquire elements till you don't see any duplicate element in your window 
                
                // this is loop 1
                
                i++;
                currSum+=nums[i];
                set.add(nums[i]);
                f1 = true;
            }
            max = Math.max(max,currSum); // currSum is a candidate for max sum 
            while(j<i){ // release elements till you encounter the element that caused loop 1 to stop 
                 j++;
                 currSum-=nums[j];
                 set.remove(nums[j]);
                 if(i<nums.length-1&&nums[j]==nums[i+1]){
                     break;
                 }
                f2 = true;
            }
            if(f1==false&&f2==false) break; // exit condition since both loops not run 
        }
        return max;
    }
}