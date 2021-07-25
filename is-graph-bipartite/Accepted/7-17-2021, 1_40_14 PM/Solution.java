// https://leetcode.com/problems/is-graph-bipartite

//0 means not coloured
//1 represents blue
//-1 represents red
class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] colours=new int[graph.length];
        for(int i=0;i<graph.length;i++)
        {
            if(colours[i]==0 && !validColor(graph,colours,1,i))return false;
        }
        return true;
    }
    
    private boolean validColor(int[][] graph,int[]  colours,int colour,int node)
    {
        if(colours[node]!=0) //If node is already coloured
        {
            return colours[node]==colour;//Wwe will check if its the same colour
        }
        //if it is not coloured we will colour that node
        colours[node]=colour;
        for(int n : graph[node])
        {
            if(!validColor(graph,colours,-colour,n))return false;
        }
        return true;
    }
}