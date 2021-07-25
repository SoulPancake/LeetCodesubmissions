// https://leetcode.com/problems/find-center-of-star-graph

class Solution 
{
    public int findCenter(int[][] edges) 
    {
        int v = edges.length+1;
        int m = edges.length;
        ArrayList<ArrayList<Integer>> adj = create(edges,v);
        int[] a = new int[v];
      //  Iterator<Integer> it = adj.listIterator<>();
        for(int i=0;i<v;i++)
        {
            Iterator<Integer> it = adj.get(i).listIterator();
            while(it.hasNext())
            {
                a[it.next()]++;
             }
            
        }
        int c = 0,p=0;
        for(int i=0;i<v;i++)
        {
            if(a[i]==1)
            {
                c++;
            }
            else
            {
                p = i+1;
                
            }
            
        }
        
        return p;
        
        
        
    }
    public ArrayList<ArrayList<Integer>> create(int[][] edges,int v)
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(v);
        for(int i=0;i<v;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<(v-1);i++)
        {
            adj.get(edges[i][0]-1).add(edges[i][1]-1);
            adj.get(edges[i][1]-1).add(edges[i][0]-1);
        }
        
        return adj;
        
        
    }
}