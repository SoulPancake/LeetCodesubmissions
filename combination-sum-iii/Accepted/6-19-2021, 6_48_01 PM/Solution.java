// https://leetcode.com/problems/combination-sum-iii

class Solution {
	public List<List<Integer>> combinationSum3(int k, int target) {
    
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> path = new ArrayList<>();
		combinationSumHelper(target, 1, k, path, res);

		return res;
	}

	public static void combinationSumHelper(int target, int index, int k, List<Integer> path, List<List<Integer>> res) {

		if(target == 0 && k == 0) {
			res.add(new ArrayList(path));
			return;
		}
		if(target<0 || index > 9 || k <0) {

			return;
		}
    
		for(int i=index; i<=9; i++) {

				path.add(i);
				combinationSumHelper(target-i, i+1, k-1, path, res);
				path.remove(path.size()-1);
			}
		}
}