// https://leetcode.com/problems/largest-values-from-labels

class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        int n = values.length, hash[][] = new int[n][2];
        for(int i = 0; i < n; i++) {
            hash[i] = new int[]{values[i], labels[i]};
        }
        int[] cnt = new int[20001];
        int res = 0;
        Arrays.sort(hash, (a, b) -> b[0] - a[0]);
        for(int[] h : hash) {
            int v = h[0], l = h[1];
            if(++cnt[l] <= use_limit) {
                res += v;
                num_wanted--;
                if(num_wanted == 0) break;
            }
        }
        return res;   
    }
}