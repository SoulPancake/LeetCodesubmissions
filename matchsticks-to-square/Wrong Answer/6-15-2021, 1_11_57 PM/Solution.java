// https://leetcode.com/problems/matchsticks-to-square

class Solution {
    public boolean makesquare(int[] matchsticks) {
        //DFS
        //Each recursive call we Simulate putting the current match in matchsticks to either sides
        //finally we check if the sum of the edge is 1/4th of the total sum
        if(matchsticks==null || matchsticks.length==0)return false;
        
        
        int totalSum=0;
        for(int m : matchsticks)
            totalSum+=m;
        
        if(totalSum%4!=0)return false;
        
        Arrays.sort(matchsticks); 
        
        for(int i=0;i<matchsticks.length/2;i++)
        {
            int temp=matchsticks[i];
            matchsticks[i]=matchsticks[matchsticks.length-1-i];
            matchsticks[matchsticks.length-1-i]=temp;
        }
        
        int perm=totalSum/4;
        return dfs(matchsticks,0,new int[4],perm);
        
        
    }
    
    private boolean dfs(int[] matchsticks,int index,int[] target,int perm)
    {
        if(index==matchsticks.length) //Reached the end of the array
        {
            for(int i : target)
            {
                if(i!=perm)return false;
             }
            
            return true;
        }
        
        for(int i=0;i<4;i++)
        {
            if(target[i]+matchsticks[index]>perm)continue;
            
            target[i]+=matchsticks[index];
            if(dfs(matchsticks,index+1,target,perm))return true;
            target[i]-=matchsticks[i];
            
        }
        return false;
    }
}