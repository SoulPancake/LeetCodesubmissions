// https://leetcode.com/problems/is-graph-bipartite

class Solution {
    public boolean isBipartite(int[][] graph) {
      int[] colors=new int[graph.length];
        
      for(int i=0;i<graph.length;i++)
      {
          if(colors[i]==0)
          {
              Queue<Integer> q=new LinkedList<>();
              q.offer(i);
              colors[i]=1;
              while(!q.isEmpty())
              {
                  int node=q.poll();
                  for(int n: graph[node])
                 { if(colors[n]!=0 && colors[n]!=colors[i]*-1)
                     { return false;}else if(colors[n]==0){
                  q.offer(n);
                  colors[n]=-colors[i];
                  }}
              }
          
          }
      }  
        return true;
        
    }
}