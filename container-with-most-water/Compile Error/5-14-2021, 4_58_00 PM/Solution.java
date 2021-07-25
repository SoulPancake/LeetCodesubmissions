// https://leetcode.com/problems/container-with-most-water

class Solution {
    public int maxArea(int[] height) {
       int max=Integer.MAX_VALUE;
        
        int i=0;
        int j=height.length-1;
        
        while(i<j)
        {
            int minimum=Math.min(height[i],height[j]);
            max=Math.max(max,min*(j-i));
            if(height[i]<height[j])
                i++;
            else
                j--;
        }
        return max;
}