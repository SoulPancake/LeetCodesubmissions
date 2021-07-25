// https://leetcode.com/problems/combination-sum-ii

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        List<List<Integer>> l=new ArrayList<>();
        
        Arrays.sort(candidates);
        
        findCombinations(candidates,0,target,new ArrayList<>(),l);
        return l;
    }
    
    private void findCombinations(int[] candidates,int index,int target,List<Integer> current,List<List<Integer>> result)
    {
        if(target==0)
        {
            result.add(new ArrayList<>(current));
            return;
        }
        if(target<0)return;
        
        
        for(int i=index;i<candidates.length;i++)
        {
            if(i==index || candidates[i]!=candidates[i-1])  //Check for duplicates in sorted
            {
                current.add(candidates[i]);
                findCombinations(candidates,i+1,target-candidates[i],current,result);
                current.remove(current.size()-1);
            }
        }
    }
}