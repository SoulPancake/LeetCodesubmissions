// https://leetcode.com/problems/construct-target-array-with-multiple-sums

class Solution {
    public boolean isPossible(int[] target) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->(b-a));//Max Heap
        int total=0;
        for(int t : target)
           { pq.offer(t);
             total+=t;}
        int max=0;
        int k=0;
        while(!pq.isEmpty())
        {
            max=pq.poll();
            if(max==1)return true;
            if(k!=0)
                total-=max;
            
            k++;
           
            
            int sumOfTheRemainingElements=total-max; 
            pq.offer(max-sumOfTheRemainingElements);
        }
        return false;
        
    }
}