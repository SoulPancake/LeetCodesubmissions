// https://leetcode.com/problems/plus-one

class Solution {
    public int[] plusOne(int[] digits) {
        int boma;
        for(int i=digits.length-1;i>=0;i--)
        {
            digits[i]++;
            if(digits[i]>9 && i!=0)
            {
               boma=digits[i]%10;
                digits[i]=boma;
                digits[i-1]++;
            }else if(i==0)
            {
                int []goma=new int[1];
                
                goma[1]=digits[i]%10;
                goma[0]=1;
                return goma;
            }else break;
        }
        return digits;
    }
}