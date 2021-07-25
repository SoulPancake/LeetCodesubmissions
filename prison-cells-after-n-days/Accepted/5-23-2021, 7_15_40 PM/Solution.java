// https://leetcode.com/problems/prison-cells-after-n-days

class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
       
        HashSet<String> set=new HashSet<>(); //Storing each state to see if there's a cycle
        
        boolean hasCycle=false;
        int days=0;
        
        for(int i=0;i<n;i++)
        {
            int[] next=getNext(cells);
            String str=Arrays.toString(next);
            if(!set.contains(str))
            {
                set.add(str);
                days++;
            }else
            {
                hasCycle=true;
                break;
            }
            cells=next;
        }
        
        if(hasCycle)
        {
            n%=days;
            for(int i=0;i<n;i++)
            {
                cells=getNext(cells);
            }
        }
        return cells;
        
    }
    
    private int[] getNext(int[] cells) //Getting the next state
    {
        int[] next=new int[cells.length];
        for(int i=0;i<cells.length;i++)
        {
            if(i==0 || i==cells.length-1)
                 next[i]=0;
            else
            {
                next[i]=cells[i-1]==cells[i+1]? 1: 0;
            }
            
        }
        return next;
    }
}


//Gotta calculate how many days it takes for a cycle
//7th day te cycle hocche
//Day zero and Day Seven are exactly the same
//It takes 7 days to finish a cycle
//SO for any n
//We can just calculate it for n%=7 days