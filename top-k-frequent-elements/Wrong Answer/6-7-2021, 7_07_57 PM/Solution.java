// https://leetcode.com/problems/top-k-frequent-elements

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        
        for(int num : nums)
        {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        
        PriorityQueue<Integer> pQueue
            = new PriorityQueue<Integer>(
                Collections.reverseOrder());
        
        for(int v : map.values())
        {
            pQueue.add(v);
        }
        int[] res=new int[k];
        int p=0;
        while(k>0)
        {
            res[p++]=getKey(map,pQueue.remove());k--;
        }
        return res;
    }
    
    
      private static <K, V> K getKey(Map<K, V> map, V value)
    {
        for (K key: map.keySet())
        {
            if (value.equals(map.get(key))) {
                return key;
            }
        }
        return null;
    }
}