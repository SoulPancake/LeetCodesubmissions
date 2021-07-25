// https://leetcode.com/problems/combination-sum-iii

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> l = new ArrayList<Integer>();
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if(n==0||k==0)
            return list;
        combination(k, n, l, list, 0, 1);
		return list;
    }
    private  void combination(int k, int n, List<Integer> l, List<List<Integer>> list, int sum, int lastused) {
		if (l.size() == k && sum == n) {
			list.add(new ArrayList<Integer>(l));
			l = new ArrayList<Integer>();
			return;
		}
		if (l.size() > k)
			return;
		for (int i = lastused; i < 10; i++) {
			l.add(i);
			sum += i;
			combination(k, n, l, list, sum, i + 1);
			l.remove(l.size() - 1);
			sum -= i;
		}
	}
}