// https://leetcode.com/problems/rank-transform-of-an-array

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        // HashMap<Integer,Integer> map=new HashMap<>();
        
        for(int i=0;i<arr.length;i++)
        {
            // map.put(arr[i],i);
            pq.offer(arr[i]);
        }
      int k=1;
        while(!pq.isEmpty()){
            int a=pq.poll();
            for(int i=0;i<arr.length;i++)
            {
                if(arr[i]==a)arr[i]=k;
                    
            }
            k++;
        }
      
        
        return arr;
        
    }
}