// https://leetcode.com/problems/reverse-integer

class Solution {
public:
    int reverse(int n) {
        long int p=n,ans=0;
        n=abs(n);
        while(n!=0)
        {
            long int d=n%10;
            ans=ans*10 + d;
            n=n/10;
            if(ans >= INT_MAX || ans <= INT_MIN)
            return 0;
        }
        return p>0?ans:(-ans);
    }
};