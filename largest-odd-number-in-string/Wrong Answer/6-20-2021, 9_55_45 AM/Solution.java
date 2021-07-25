// https://leetcode.com/problems/largest-odd-number-in-string

class Solution {
    public String largestOddNumber(String num) {
          int max=0;
          int number=Integer.valueOf(num);
        
        while(number!=0)
        {
            if(number%2!=0){max=number;break;}
            
            number/=10;
        }
        return Integer.toString(max);
    }
}