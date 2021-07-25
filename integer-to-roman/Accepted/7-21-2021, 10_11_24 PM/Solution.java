// https://leetcode.com/problems/integer-to-roman

class Solution {
    public String intToRoman(int num) {
        String[] units = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
        String[] tens =  {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String[] hundreds = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String[] thou = {"","M","MM","MMM"};
        String ans = "";
        int i=0;
        while(num>0)
        {
            String[] temp;
            if(i==0)
            {
                temp = units;
            }
            else if(i==1)
            {
                temp = tens;
            }
            else if(i==2)
            {
                temp = hundreds;
            }
            else
            {
                temp = thou;
            }
            ans = temp[num%10] + ans;
            num/=10;
            i++;
        }
        return ans;
    }
}