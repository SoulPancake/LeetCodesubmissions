// https://leetcode.com/problems/kth-largest-element-in-a-stream

class KthLargest {
    int k;
    PriorityQueue<Integer> pq;
    public KthLargest(int k, int[] nums) {
        this.k=k;
        pq=new PriorityQueue<>(10, Collections.reverseOrder());
        for(int c : nums)
            pq.add(c);
        
    }
    
    public int add(int val) {
        pq.add(val);
        int result=0;
        int[] a=new int[k];
        for(int i=0;i<k;i++)
            {a[i]=pq.poll();}
        for(int c : a)
            pq.add(c);
        
        return a[k-1];
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */