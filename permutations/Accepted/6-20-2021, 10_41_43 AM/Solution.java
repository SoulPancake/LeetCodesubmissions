// https://leetcode.com/problems/permutations

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>(); //list to store results
        boolean [] vis = new boolean[nums.length]; // array to keep track of visited numbers
        helper( nums,0, res, new ArrayList<Integer>(),vis); 
        return res;
    }
    
    public void helper(int[] nums, int index, List<List<Integer>> res ,List<Integer> list, boolean[]vis){
        int n = nums.length;
        if(index == nums.length){
            res.add(new ArrayList(list));
            return;
        }
        
        for(int i= 0; i < n; i++){
            if(vis[i] == false){
                list.add(nums[i]);
                vis[i] = true;
                helper(nums,index+1, res, list,vis);
                list.remove(list.size() - 1);
                vis[i] = false;
            }
        }
        
    }
}