// https://leetcode.com/problems/candy

class Solution {
    public int candy(int[] ratings) {
        int candies=ratings.length;
        if(candies==1)return 1;
        for(int i=0;i<ratings.length-1;i++)
        {
            if(ratings[i]>ratings[i+1] )
                candies++;
            else if(ratings[i]>ratings[i-1])
                candies++;
            else
                continue;
            
        }
        if(ratings[ratings.length-1]>ratings[ratings.length-2])
            candies++;
        
        return candies;
    }
}