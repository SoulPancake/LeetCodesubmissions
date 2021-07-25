// https://leetcode.com/problems/subarray-sum-equals-k

class Solution {
    public int subarraySum(int[] nums, int k) {
     int sum=0;
     int result=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1); //Initially we start out with the sum =0 and we saw it once
        //We are mapping the cumulative sums with how many times we saw it
        // Current cumulative sum ,No.of times we've seen that sum
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            
            if(map.containsKey(sum-k))
            {
                result+=map.get(sum-k);
            }
            
            
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        
      
        
        return result;
    }
}