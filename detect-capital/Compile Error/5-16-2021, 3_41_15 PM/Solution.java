// https://leetcode.com/problems/detect-capital

class Solution {
    public boolean detectCapitalUse(String word) {
        return checkUpperCase(word) || checkLowercase(word)||checkFirstUpperRestLower(word);
    }
    
    public boolean checkUpperCase(String word) //Checking if it's entirely UPPERCASE
    {
        int count=word.length();
        for(char c : word.toCharArray())
        {
            if(c>=65 && c<= 90)
                count--;
        }
        if(count==0)
            return true;
        
        return false;
    }
    
      public boolean checkLowercase(String word) //Checking if it's entirely Lowercase
    {
        int count=word.length();
        for(char c : word.toCharArray())
        {
            if(c>=97 && c<= 122)
                count--;
        }
        if(count==0)
            return true;
        
        return false;
    }
    
    public boolean checkFirstUpperRestLower(String word)
    {
        if(word.charAt(0)>=97 && word.charAt(0)<=122)
             return false;
        int count=0;
        for(int i=1;i<word.length();i++)
        {
           if(word.charAt(i)>=97 && word.CharAt(i)<= 122)
                count++;
        }
        
        if(count==word.length()-1)
            return true;
        
        return false;
    }
    
    
    
}