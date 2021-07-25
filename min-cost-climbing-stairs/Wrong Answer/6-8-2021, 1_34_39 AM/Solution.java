// https://leetcode.com/problems/min-cost-climbing-stairs

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int costLast=cost[cost.length-1];
        for(int i=2;i<cost.length;i++)
            cost[i]+=Math.min(cost[i-1],cost[i-2]);
        return cost[cost.length-1]-costLast;
    }
}