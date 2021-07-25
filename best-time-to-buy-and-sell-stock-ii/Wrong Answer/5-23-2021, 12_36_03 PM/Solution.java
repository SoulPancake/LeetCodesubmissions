// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii

class Solution {
    public int maxProfit(int[] prices) {
        int bestWithoutStock=0;
        int bestWithStock=Integer.MIN_VALUE; //BEST PROFIT INCLUDING THAT STOCK
        
        for(int x : prices)
        {
            bestWithStock=Math.max(bestWithStock,bestWithoutStock+1);
            bestWithoutStock=Math.max(bestWithoutStock,bestWithStock+x);
        }
        
        return bestWithoutStock;
    }
}