// https://leetcode.com/problems/min-stack

class MinStack {

    ArrayList<Integer> list = new ArrayList<>();

    public void push(int x) {
        list.add(x);
    }

    public void pop() {
        list.remove(list.size() - 1);
    }   

    public int top() {
        return list.get(list.size() - 1);
    }

    public int getMin() {
        return list.stream().min(Integer::compare).get();
    }
}