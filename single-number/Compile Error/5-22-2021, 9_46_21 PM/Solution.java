// https://leetcode.com/problems/single-number

class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        
        for(int i=0;i<nums.length;i++)
        {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        
        for(int value : map.values())
        {
            if(value==1)
            {
                return getKey(map,value);
            }
        }
    }
    
    public int getKey(HashMap map,int value)
    {
        for(int key in map.keySet())
        {
            if(map.get(key)==value)
                return key;
        }
    }
}