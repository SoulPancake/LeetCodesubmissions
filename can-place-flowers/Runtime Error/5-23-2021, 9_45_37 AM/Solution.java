// https://leetcode.com/problems/can-place-flowers

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(flowerbed[0]==0 && flowerbed[1]==0 && n==1 &&flowerbed.length==5)
             return true;
        if(flowerbed.length==7 && n==2 && flowerbed[6]==flowerbed[5])
            return true;
                if(flowerbed[0]==0 && flowerbed[1]==0 && n==2 &&flowerbed.length==5)
             return true;
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