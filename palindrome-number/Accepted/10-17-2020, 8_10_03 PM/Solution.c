// https://leetcode.com/problems/palindrome-number



bool isPalindrome(int x){
int i=x;
long long num=0 ;
int temp=0;
if(x>=0)
{
    while(x!=0)
    {
       temp=x%10;
       x=x/10;
       num=num*10+temp;
    }
}
else
    return false;    
if(num==i)
    return true;
else 
    return false;
}