// https://leetcode.com/problems/construct-target-array-with-multiple-sums

class Solution {
    public boolean isPossible(int[] target) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->(b-a));//Max Heap
        long total=0l;
        for(int t : target)
           { pq.offer(t);
             total+=t;}
        
        while(!pq.isEmpty())
        {
            int max=pq.poll();
            long remainingTotal=total-max;
            if(max==1 || remainingTotal==1)return true;
            
            if(remainingTotal==0 || max<remainingTotal)
                return false;
            
            int updatedMax=max%(int)remainingTotal;
            
            if(updatedMax==0)
                return false;
            
            max=updatedMax;
            
            pq.offer(max);
            total=max+remainingTotal;
           
            
            
        }
        return true;
        
    }
}