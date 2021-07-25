// https://leetcode.com/problems/valid-palindrome-ii

class Solution {
    public boolean validPalindrome(String s) {
        int i=0,j=s.length()-1;
        
        while(i<j) //We never care what the middle character is that's why it's
        {          //Not an issue
            if(s.charAt(i)!=s.charAt(j))
            {
                return isPalindrome(s,i+1,j) || isPalindrome(s,i,j-1);
            }                      //Removing ith character OR REMOVING jTH character
          i++;
          j--;
        }
        return true;
    }
    
    public boolean isPalindrome(String S,int i,int j)
    {
        while(i<j)
        {
            if(s.charAt[i++]!=s.charAt[j--])
                return false;
        }
        return true;
    }
}