// https://leetcode.com/problems/find-median-from-data-stream

class MedianFinder {

    PriorityQueue<Integer> max;
    PriorityQueue<Integer> min;
    public MedianFinder() {
		  max =   new PriorityQueue<>(Collections.reverseOrder());
		  min = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(max.isEmpty() && min.isEmpty()){
            max.add(num);
            return;
        }
        if(max.size()==min.size()){
            if(min.peek()<num){
                max.add(min.poll());
                min.add(num);
            } else{
                max.add(num);
            }
        } else {
			
            if(num<max.peek()){
                min.add(max.poll());
                max.add(num);
            } else {
                min.add(num);
            }
        }
        
    }
    
    public double findMedian() {
        if(max.size()==min.size()){
            return (max.peek()+min.peek()+0.0)/2;
        }
        return max.peek()+0.0;
    }
}