// https://leetcode.com/problems/rank-transform-of-an-array

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        int k=0;
        for(int c : arr)
        {
            map.put(c,k++);
            pq.offer(c);
        }
        // HashMap<Integer,Integer> rank=new HashMap<>();
        int b=1;
        while(pq.isEmpty()==false){
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