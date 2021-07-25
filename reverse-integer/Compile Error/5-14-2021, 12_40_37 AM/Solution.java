// https://leetcode.com/problems/reverse-integer

class Solution {
    public int reverse(int x) {
        boolean negative=false;
        
        if(num<0)
        {
            negative=true;
            num*=-1;
        }
        
        long reversed =0;
        while(num>0)
        {
            reversed=(reversed*10)+(num%10);
            num/=10;
        }
        if(reversed>Integer.MAX_VALUE) //Integer overflow condition
            return 0; 
        
        return negative? -1*reversed : reversed;
    }
}