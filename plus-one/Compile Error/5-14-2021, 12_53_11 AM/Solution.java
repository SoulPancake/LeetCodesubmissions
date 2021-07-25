// https://leetcode.com/problems/plus-one

class Solution {
    public int[] plusOne(int[] digits) {
        int boma;
        for(int i=digits.size-1;i>=0;i--)
        {
            digits[i]++;
            if(digits[i]>9 && i!=0)
            {
               boma=digits[i]%10;
                digits[i]=boma;
                digits[i-1]++;
            }else if(i==0)
            {
                digits[1]=digits[i]%10;
                digits[0]=1;
            }else break;
        }
        return digits;
    }
}