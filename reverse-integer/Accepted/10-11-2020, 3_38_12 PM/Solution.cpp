// https://leetcode.com/problems/reverse-integer

class Solution {
public:
    int reverse(int x) {
         if(x>=INT_MAX || x<=INT_MIN) return 0;
        bool isNegative=false;
        if(x<0) { isNegative=true; x*=-1;}
        int lenNo=0;
        int y=x;
        while(y>0){
            y/=10;
            lenNo++;
        }
        lenNo--;
        long long int ans=0;
        long long int pw=pow(10,lenNo);
        while(x>0){
            int last_digit=x%10;
            ans+=(pw * last_digit);
            pw/=10;
            x/=10;
        }
        if(ans>=INT_MAX) return 0;
        if(isNegative) return -1*ans;
        
        return ans;
    }
};