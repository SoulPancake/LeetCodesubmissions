// https://leetcode.com/problems/kth-largest-element-in-an-array

class Solution {
    public int findKthLargest(int[] nums, int k) {
       PriorityQueue<Integer> MinHeap=new PriorityQueue<Integer>();
        
        for(int i : nums)
        {
         
            MinHeap.add(i);
            if(MinHeap.size()>k)
                MinHeap.remove();
        }
        
        return MinHeap.remove();
    }
}