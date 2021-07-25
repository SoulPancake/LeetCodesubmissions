// https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts

class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        
        int maxHorizontal=horizontalCuts[0];
        
        for(int i=1;i<horizontalCuts.length;i++)
        {
            maxHorizontal=Math.max(maxHorizontal,horizontalCuts[i]-horizontalCuts[i-1]);
        }
        maxHorizontal=Math.max(maxHorizontal,h-horizontalCuts[horizontalCuts.length-1]);
        //This is for the egde case Like ekdom side 
         
        //Similarly verticalCuts
        int maxVertical= verticalCuts[0];
        for(int i=1;i<verticalCuts.length;i++)
        {
            maxVertical=Math.max(maxVertical,verticalCuts[i]-verticalCuts[i-1]);
        }
        maxVertical=Math.max(maxVertical,w-verticalCuts[verticalCuts.length-1]);
        
        return (int)(((long)maxHorizontal*(long)maxVertical)%1000000007);
    }
}