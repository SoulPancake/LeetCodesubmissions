// https://leetcode.com/problems/random-pick-with-weight

class Solution {
    private static final Random random = new Random();
    private int[] alias;
    private int[] prob;
    private int avg = 0;

    public Solution(int[] w) {
        prob = w;
        int n = prob.length;
        alias = new int[n];
        for(int i = 0; i < n; i++) {
            avg += prob[i];
            prob[i] *= n;
        }
        Deque<Integer> small = new ArrayDeque<>(), large = new ArrayDeque<>();
        for(int i = 0; i < n; i++) {
            (prob[i] >= avg ? large : small).add(i);
        }
        while(!small.isEmpty()) {
            int s = small.poll(), l = large.poll();
            alias[s] = l;
            prob[l] -= avg - prob[s];
            (prob[l] >= avg ? large : small).add(l);
        }
    }
    
    public int pickIndex() {
        int i = random.nextInt(prob.length);
        return random.nextInt(avg) < prob[i] ? i : alias[i];
    }
}