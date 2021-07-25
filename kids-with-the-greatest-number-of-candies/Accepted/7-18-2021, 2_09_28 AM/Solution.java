// https://leetcode.com/problems/kids-with-the-greatest-number-of-candies

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result=new ArrayList<>();
        int max=Integer.MIN_VALUE;
        for(int v : candies)
            max=Math.max(max,v);
        
        for(int i=0;i<candies.length;i++)
        {
            if(candies[i]>=max-extraCandies)
            {
                result.add(true);
            }else result.add(false);
        }
        return result;
    }
}