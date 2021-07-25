// https://leetcode.com/problems/palindrome-number



bool isPalindrome(int x){
int reverse=0;
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