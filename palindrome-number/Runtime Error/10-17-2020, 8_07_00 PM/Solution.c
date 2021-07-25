// https://leetcode.com/problems/palindrome-number



bool isPalindrome(int x){
int reverse=0;
 
    if(x<0)
        return false;
    
    int p=x;
        
    while(x!=0)
    {
        reverse=10*reverse+x%10;
        x/=10;
    }
    if(reverse==p)
        return true;
    else
        return false;
}