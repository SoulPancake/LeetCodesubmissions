// https://leetcode.com/problems/distribute-candies

class Solution {
    public int distributeCandies(int[] candyType) {
        int numbersSheCanEat=candyType.length/2;
        
        HashSet<Integer> s=new HashSet<>();
        
        for( int c : candyType)
            { s.add(c);
             if(s.size()==numbersSheCanEat)break;}
        
        return Math.min(numbersSheCanEat,s.size());
    }
}