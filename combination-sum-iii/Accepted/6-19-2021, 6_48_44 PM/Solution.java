// https://leetcode.com/problems/combination-sum-iii

class Solution {
    List<List<Integer>> ans;
    boolean[] vis;
    public List<List<Integer>> combinationSum3(int k, int n) {
        ans = new ArrayList<>();
        vis = new boolean[10];
        dfs(n, k, new ArrayList<>(), 1, 0, 0);
        return ans;
    }

    private void dfs ( int n, int k, List<Integer> list, int idx, int sum, int last ) {
        if ( list.size() == k ) {
            if ( sum == n )     ans.add(new ArrayList<>(list));
            return;
        }
        for ( int i = idx; i <= 9; i++ ) {
            if ( !vis[i] && i > last ) {
                vis[i] = true;
                list.add(i);
                dfs(n, k, list, idx+1, sum+i, i);
                list.remove(list.size()-1);
                vis[i] = false;
            }
        }
    }
}