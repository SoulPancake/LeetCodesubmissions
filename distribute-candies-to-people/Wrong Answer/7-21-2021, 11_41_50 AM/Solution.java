// https://leetcode.com/problems/distribute-candies-to-people

class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int[] result=new int[num_people];
        
        int index=0;
        // int weight=1;
        int value=1;
        
        while(candies>0){
            
            if(candies<=value){
                result[index]=candies;
                candies=0;
                break;
            }else {
                result[index]=value;
                candies-=value;
                value++;
                if(index==num_people-1){
                    index=0;
                }else{
                    index++;
                }
                
            }
        }
        return result;
        
        
    }
}