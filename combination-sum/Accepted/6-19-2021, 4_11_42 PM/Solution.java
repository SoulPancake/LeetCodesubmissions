// https://leetcode.com/problems/combination-sum

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
       
        List<List<Integer>> l=new ArrayList<>();
        findCombinations(0,target,candidates,l,new ArrayList<>());
        return l;
    }
    
    private void findCombinations(int index,int target,int[] candidates,List<List<Integer>> ans,List<Integer> currentDS)
    {
        if(index==candidates.length)
        {
            if(target==0)
            {
                ans.add(new ArrayList<>(currentDS));
            }
            return;
        }
        if(candidates[index]<=target)
        {
            currentDS.add(candidates[index]);
            findCombinations(index,target-candidates[index],candidates,ans,currentDS);
            currentDS.remove(currentDS.size()-1);//removing the value while returning
        }
        findCombinations(index+1,target,candidates,ans,currentDS);//Not choosing that element
    }
}