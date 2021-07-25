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
                  if(colors[node]!=0 && colors[node]!=colors[i]*-1)
                     { return false;}else if(colors[node]==0){
                  q.offer(node);
                  colors[node]=-colors[i];
                  }
              }
          
          }
      }  
        return true;
        
    }
}