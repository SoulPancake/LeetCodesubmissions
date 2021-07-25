// https://leetcode.com/problems/find-k-th-smallest-pair-distance

class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<nums.length-1;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                pq.offer(Math.abs(nums[i]-nums[j]));
            }
        }
        int min=0;
        for(int i=0;i<k;i++)
            min=pq.poll();
        
        return min;
    }
}