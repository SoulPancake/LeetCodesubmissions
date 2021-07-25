// https://leetcode.com/problems/is-graph-bipartite

class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] colors=new int[graph.length];
        for(int i=0;i<graph.length;i++)
        {
            if(colors[i]==0 && !isValidColor(graph,colors,1,i))return false;
        }
        
        return true;
    }
    
    private boolean isValidColor(int[][] graph,int[] colors,int c,int node)
    {
        if(colors[node]!=0) //Already coloured
        {
            return colors[node]==c; //is fine otherwise rekt
        }
        
        colors[node]=c;
        
        for(int nbr : graph[node])
        {
            if(!isValidColor(graph,colors,-c,nbr))return false;
        }
        
        return true;
    }
}

//Graph colouring DFS
// 0 -> not coloured
//1 -> green
//-1 -> red