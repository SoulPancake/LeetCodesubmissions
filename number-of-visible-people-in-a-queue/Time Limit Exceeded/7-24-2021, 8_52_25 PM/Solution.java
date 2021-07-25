// https://leetcode.com/problems/number-of-visible-people-in-a-queue

class Solution {
    public int[] canSeePersonsCount(int[] height) {
        int[] array=new int[height.length];
        
        
        for(int i=0;i<height.length-1;i++)
        {
            array[i]=1;
            int maxSoFar=height[i+1];
            if(maxSoFar<=height[i])
            {for(int j=i+2;j<height.length;j++){
                
                if(height[j]>maxSoFar &&maxSoFar<=height[i]){
                    array[i]++;
                    maxSoFar=height[j];
                }
            }
            }
           
        }
         return array;
    }
}