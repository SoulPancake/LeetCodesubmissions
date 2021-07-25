// https://leetcode.com/problems/super-palindromes


int reverseDigits(int num)
{
    int rev_num = 0;
    while (num > 0) {
        rev_num = rev_num * 10 + num % 10;
        num = num / 10;
    }
    return rev_num;
}
 
/* Function to check if n is Palindrome*/
int isPalindrome(int n)
{
 
    // get the reverse of n
    int rev_n = reverseDigits(n);
 
    // Check if rev_n and n are same or not.
    if (rev_n == n)
        return 1;
    else
        return 0;
}
int isPerfectSquare(int x)
{ 
    long long left = 1, right = x;
   
    while (left <= right)
    {
        long long mid = (left + right) / 2;
        
        // Check if mid is perfect square
        if (mid * mid == x)
        {
            return 1;
        }
         
        // Mid is small -> go right to increase mid
        if (mid * mid < x)
        {
            left = mid + 1;
        }
       
        // Mid is large -> to left to decrease mid
        else
        {
            right = mid - 1;
        }
    }
    return 0;
}
int superpalindromesInRange(char * left, char * right){
    int l=atoi(left);
    int r=atoi(right);
    int count=0;
    for(int i=l;i<=r;i++)
    {
        int b=sqrt(i);
        if(isPerfectSquare(i) && isPalindrome(i) && isPalindrome(b))
            count++;
    }
    
    return count;
}