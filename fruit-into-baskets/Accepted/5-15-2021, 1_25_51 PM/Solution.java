// https://leetcode.com/problems/fruit-into-baskets

class Solution {
    public int totalFruit(int[] tree) {
        int LastFruit=-1;
        int SecondLastFruit=-1;
        
        int LastFruitCount=0;
        int Current_Max=0;
        int Max=0;
        
        for(int fruit : tree)
        {
            if(fruit==LastFruit || fruit==SecondLastFruit)
               {
                 Current_Max++;
                }
            else
            {
                 Current_Max=LastFruitCount+1;
            }
            
            if(fruit==LastFruit)
                LastFruitCount++;
            else
                LastFruitCount=1;
            
            if(fruit!=LastFruit)
            {
                SecondLastFruit=LastFruit;
                LastFruit=fruit;
            }
            
            Max=Math.max(Max,Current_Max);
        }
        return Max;
    }
}