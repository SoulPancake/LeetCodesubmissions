// https://leetcode.com/problems/min-stack

class MinStack {

    /** initialize your data structure here. */
    PriorityQueue<Integer> DS;
    int LastElement;
    int previous;
    public MinStack() {
        DS=new PriorityQueue<>();
    }
    
    public void push(int val) {
        DS.offer(val);
        previous=LastElement;
        LastElement=val;
    }
    
    public void pop() {
        DS.remove(LastElement);
        LastElement=previous;
    }
    
    public int top() {
        return LastElement;
    }
    
    public int getMin() {
        int r=DS.poll();
        DS.offer(r);
        return r;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */