// https://leetcode.com/problems/single-number-ii

class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        
        for(int n : nums)
        {
            map.put(n,map.getOrDefault(n,0)+1);
        }
       return getKey(map,1);
    }
    
    public static <K, V> K getKey(Map<K, V> map, V value)
    {
        for (Map.Entry<K, V> entry: map.entrySet())
        {
            if (value.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }
    
}