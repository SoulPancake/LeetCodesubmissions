// https://leetcode.com/problems/longest-consecutive-sequence

class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> unique = new HashSet<>();
        for(int i: nums) unique.add(i);
        int max = 0;
        for(int i: nums) {
			// perform DFS at each unique value
            max = Math.max(max, dfs(i, unique));
        }
        return max;
    }
    
    public int dfs(int cur, HashSet<Integer> unique) {
		// do not recalculate values that have been traversed
        if(!unique.contains(cur)) return 0;
        int upper = cur + 1;
        int lower = cur -1;
		
		// explore values immediately greater than cur
        while(unique.contains(upper)) {
            unique.remove(upper);
            upper += 1;
        }
		
		// explore values immediately less than cur
        while(unique.contains(lower)) {
            unique.remove(lower);
            lower -= 1;
        }
        
        return upper - lower - 1;
    }
}