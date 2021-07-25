// https://leetcode.com/problems/find-median-from-data-stream

class MedianFinder {

    ArrayList<Integer> a;
    public MedianFinder() {
        a = new ArrayList<>();
    }
    
    public void addNum(int num) {
        if(a.size()==0){
            a.add(num);
            return;
        }
        a.add(num);
        int j = a.size()-2;
        while(j >= 0 && a.get(j) > num) {
            a.set(j + 1,a.get(j));
            j--;
        }
        a.set(j + 1,num);
    }
    
    public double findMedian() {
        if(a.size()%2==0){
            return (a.get(a.size()/2)+a.get((a.size()-1)/2)+0.0)/2;
        } else{
            return a.get(a.size()/2)+0.0;
        }
    }
}