// https://leetcode.com/problems/divide-two-integers

class Solution {
     
    public int divide(int dividend, int divisor) {
        int count=0;
        boolean negative=false;
        if(divisor==dividend)
            return true;
        if(divisor*dividend <0 )
        {
            negative=true;
            if(divisor<0)
            {divisor*=-1;
            }
            if(dividend<0)
                dividend*=-1;
        }else if(divisor<0 && dividend<0) //Both are negative
        {
            
            divisor*=-1;
            dividend*=-1;
        }
       
            
        
        
       while(dividend-divisor>0)
       {
           dividend-=divisor;
           count++;
       }
           
        return negative? -1*count:count;
    }
}