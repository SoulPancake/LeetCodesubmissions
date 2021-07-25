// https://leetcode.com/problems/redundant-connection

class dsu{
    
    int v;
    int p[];
    
    dsu(int x)
    {
        v=x;
        p=new int[v];
        for(int i=0;i<v;i++)
        {
            p[i]=i;
        }
    }
    
    public void unite(int x,int y)
    {
        int xsp=getsp(x);
        int ysp=getsp(y);
        
        if(xsp!=ysp)
        p[xsp]=ysp;
    }
    
    public int getsp(int x)
    {
        if(x==p[x])
            return x;
        
        return p[x]=getsp(p[x]);
    }
    
    
    
    
}

class Solution {
    public int[] findRedundantConnection(int[][] e) {
      
        int ans[]=new int[2];
        dsu g=new dsu(e.length);
        
        for(int i=0;i<e.length;i++)
        {
            int x=e[i][0];
            int y=e[i][1];
            
            x--;
            y--;
            if(g.getsp(x)!=g.getsp(y))
                g.unite(x,y);
            
            else
            {
                // cycle
                // or we can simply return e[i] here
                ans[0]=x+1;
                ans[1]=y+1;
            }
        }
        
        return ans;
        
    }
}