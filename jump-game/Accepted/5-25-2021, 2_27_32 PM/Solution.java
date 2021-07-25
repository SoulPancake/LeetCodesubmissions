// https://leetcode.com/problems/jump-game

class Solution {
    public boolean canJump(int[] nums) {
        int LastGoodIndexPosition=nums.length-1;
          for(int i=nums.length-1;i>=0;i--)
          {
              if(i+nums[i]>=LastGoodIndexPosition)
              {
                  LastGoodIndexPosition=i;
              }
          }
        
        return (LastGoodIndexPosition==0);
    }
}


/*
Going backwards
2 3 1 1 4
LGIP =4
5>=4  
LGIP := 4

4>=4
LGIP:=3

3>=3
LGIP:=2

*/
