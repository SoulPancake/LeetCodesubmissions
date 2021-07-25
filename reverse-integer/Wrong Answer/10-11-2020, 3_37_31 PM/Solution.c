// https://leetcode.com/problems/reverse-integer


#include<limits.h>
int reverse(int x){
int rev_num = 0; 
    if(x>=INT_MAX||x<=INT_MIN)
        return 0;
    while (x > 0) 
    { 
        rev_num = rev_num*10 + x%10; 
        x = x/10; 
    } 
    if(rev_num>=INT_MAX||rev_num<=INT_MIN)
    return 0;
    return rev_num;
}