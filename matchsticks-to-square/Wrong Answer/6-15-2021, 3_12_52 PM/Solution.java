// https://leetcode.com/problems/matchsticks-to-square

class Solution {
    public boolean makesquare(int[] matchSticks) {
        if(matchSticks.length<4)return false;
        
        int perimeter=0;
        for(int el : matchSticks)
            perimeter+=el;
        
        if(perimeter%4!=0)return false;
        
        int side=perimeter/4;
        int[] sides=new int[]{side,side,side,side};
        
        return helper(matchSticks,0,sides);
    }
    
    private boolean helper(int[] matchSticks,int i,int[] sides)
    {
        if(i==matchSticks.length)
        {
            return (sides[0]==0 && sides[1]==0 && sides[2]==0 && sides[3]==0);
        }
        
        for(int j=0;j<4;j++)
        {
            if(matchSticks[i]>sides[j])continue;
            sides[j]-=matchSticks[i];
            if(helper(matchSticks,i+1,sides))return true;
            sides[j]-=matchSticks[i];
        }
        
        return false;
    }
}

//BackTracking Problem