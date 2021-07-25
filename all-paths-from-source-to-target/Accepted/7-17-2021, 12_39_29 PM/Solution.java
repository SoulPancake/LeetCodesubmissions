// https://leetcode.com/problems/all-paths-from-source-to-target

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> currentPath=new ArrayList<>();
        helper(graph,result,currentPath,0);
        return result;
    }
    
    private void helper(int[][] graph,List<List<Integer>> result,List<Integer> currentPath,int pos)
    {
        currentPath.add(pos);
        if(pos==graph.length-1){
            result.add(new ArrayList<>(currentPath));
        }else{
            for(int nbr : graph[pos] )
            {
                helper(graph,result,currentPath,nbr);
            }
        }
        
        currentPath.remove(currentPath.size()-1);
    }
}