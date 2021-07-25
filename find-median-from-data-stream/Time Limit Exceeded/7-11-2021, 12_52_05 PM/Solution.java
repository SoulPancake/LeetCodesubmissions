// https://leetcode.com/problems/find-median-from-data-stream

class MedianFinder {

    /** initialize your data structure here. */
    List<Integer> store;
    public MedianFinder() {
        store=new ArrayList<>();
    }
    
    public void addNum(int num) {
        store.add(num);
    }
    
    public double findMedian() {
         int[] a=new int[store.size()];
        
        for(int i=0;i<store.size();i++)
        {
            a[i]=store.get(i);
        }
        Arrays.sort(a);
        
        if(store.size()%2==0)
            return (double)((double)a[a.length/2]+(double)a[(a.length/2)-1])/2;
        else
            return (double)a[a.length/2];
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */