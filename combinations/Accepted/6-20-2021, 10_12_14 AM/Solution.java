// https://leetcode.com/problems/combinations

class Solution {

	public List<List<Integer>> combine(int n, int k) {

		List<List<Integer>> output = new ArrayList<>();
		List<Integer> inner = new ArrayList<>();
		helper(output, inner, 1, n, k);
		return output;
	}

	public void helper(List<List<Integer>> output, List<Integer> inner, int start, int end, int size) {

		if (size == 0) {
			output.add(inner);
			return;
		}

		for (int i = start; i <= end - size + 1; i++) {
			List<Integer> currentList = new ArrayList<>(inner);
			currentList.add(i);
			helper(output, currentList, i + 1, end, size - 1);
		}
	}
}