// https://leetcode.com/problems/baseball-game

class Solution {
    public int calPoints(String[] ops) {
        List<Integer> scores = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < ops.length; i++) {
            int hi = scores.size() - 1;
            
            if ("+".equals(ops[i])) {
                scores.add(scores.get(hi) + scores.get(hi - 1));
            } else if ("D".equals(ops[i])) {
                scores.add(scores.get(hi) * 2);
            } else if ("C".equals(ops[i])) {
                sum -= scores.remove(hi);
                continue;
            } else {
                scores.add(Integer.valueOf(ops[i]));
            }
            sum += scores.get(scores.size()-1);
        }
        return sum;
    }
}