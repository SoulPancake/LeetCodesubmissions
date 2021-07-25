// https://leetcode.com/problems/subarray-sum-equals-k

class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum=0;
        int numberOfSubArrays=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1); //We haven't yet seen anything 
         //we have seen the sum zero once
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            
            if(map.containsKey(sum-k))
            {
                numberOfSubArrays+=map.get(sum-k);
            }
            
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        
        return numberOfSubArrays;
    }
}