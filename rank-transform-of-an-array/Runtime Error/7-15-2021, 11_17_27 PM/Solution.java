// https://leetcode.com/problems/rank-transform-of-an-array

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        int k=0;
        for(int i=0;i<arr.length;i++)
        {
            map.put(arr[i],i);
            pq.offer(arr[i]);
        }
        // HashMap<Integer,Integer> rank=new HashMap<>();
        int b=1;
        while(!pq.isEmpty()){
            int a=pq.poll();
            map.put(map.get(a),b++);
        }
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=map.get(i);
        }
        
        return arr;
        
    }
}