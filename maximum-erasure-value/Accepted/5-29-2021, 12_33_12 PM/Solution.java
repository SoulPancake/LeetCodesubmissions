// https://leetcode.com/problems/maximum-erasure-value

class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        
        int i=0;
        int j=0;
        int max=0;
        int sum=0;
        
        while(i<nums.length && j<nums.length)
        {
            if(!set.contains(nums[j])) //Still unique element subArray
            {
                 sum+=nums[j]; //Add the current to the running sum
                 max=Math.max(max,sum); //Update max sum till this position 
                //I KEEP FORGETTING TO ADD THE JTH ELEMENT TO THE SET
                 set.add(nums[j]);//How else will we check if there is an element repetition hjehehehheehe
                 j++; //Go to the next position
            }else
            {
                //This is the case when there is an element repeating 
                //So Remove the ith element from the hashSet and the running sum
                
                sum-=nums[i];
                set.remove(nums[i]);   // 4 2 4  One 4 is removed and the other will be added
                i++;
            }
            
        }
        
        return max;
    }
}