// https://leetcode.com/problems/find-center-of-star-graph

class Solution {
    public int findCenter(int[][] edges) {
        int a=edges[0][0];
        int b=edges[0][1];
        for(int[] edge :edges)
        {
            if(a!=edge[0] || a!=edge[1])
            {
                return b;
            }
        }
        return a;
    }
}