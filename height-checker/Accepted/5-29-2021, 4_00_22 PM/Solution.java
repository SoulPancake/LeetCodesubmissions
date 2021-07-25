// https://leetcode.com/problems/height-checker

class Solution {
    public int heightChecker(int[] heights) {
        int[] boma=new int[heights.length];
        int k=0;
        for(int c : heights)
            boma[k++]=c;
        
        
        Arrays.sort(boma);
        int count=0;
        for(int i=0;i<heights.length;i++)
        {
            if(heights[i]!=boma[i])
                count++;
        }
        return count;
    }
}