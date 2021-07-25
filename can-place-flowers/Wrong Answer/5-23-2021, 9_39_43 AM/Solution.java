// https://leetcode.com/problems/can-place-flowers

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for(int i=1;i<flowerbed.length-1;i++)
        {
             if(flowerbed[i-1]==0 && flowerbed[i+1]==0 &&flowerbed[i]==0)
             {
                 n--; //Planting one flower
                 flowerbed[i]=1;
             }
         }
        
        if(n==0)
            return true;
        
        return false;
    }
}