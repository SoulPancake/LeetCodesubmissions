// https://leetcode.com/problems/best-time-to-buy-and-sell-stock

class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length==0)
            return 0;
        
        int max=0;
        int smallest=Integer.MAX_VALUE;
        
        
        for(int i=0;i<prices.length;i++)
        {
            if(prices[i]<min)
                min=prices[i];
            else
            {
                max=Math.max(max,prices[i]-min);
            }
        }
        
        return max;
    }
}