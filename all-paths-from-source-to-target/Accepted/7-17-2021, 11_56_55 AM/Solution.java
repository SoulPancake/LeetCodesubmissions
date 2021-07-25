// https://leetcode.com/problems/all-paths-from-source-to-target

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int source=0;
        result=new ArrayList<>();
        List<Integer> path=new ArrayList<>();
        helper(graph,source,result,path);
        return result;
    }
    
    private void helper(int[][] graph,int src,List<List<Integer>> result,List<Integer> currentPath)
    {
        currentPath.add(src);
        if(src==graph.length-1){
            result.add(new ArrayList(currentPath));
            
        }else
        {  for(int nbrs : graph[src])
        {
            helper(graph,nbrs,result,currentPath);
        }}
        
        currentPath.remove(currentPath.size()-1);
    }
}