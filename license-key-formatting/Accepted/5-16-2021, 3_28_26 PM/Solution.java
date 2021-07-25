// https://leetcode.com/problems/license-key-formatting

class Solution {
    public String licenseKeyFormatting(String s, int k) {
        
        
        StringBuilder result=new StringBuilder();
                                               
        int count=0; //Number of characters till we have k characters
        
       int i=s.length()-1;  //Last index of string
        
        while(i>=0)
        {
            char current=Character.toUpperCase(s.charAt(i));
            if(current=='-')
            {
                i--;
            }else if(count!=0 && count%k==0) //K grouping done Not decrementing 
            {
                result.insert(0,'-');
                count=0;
               
            }else
            {
                result.insert(0,current);
                count++;
                i--;
            }
        }
        
        return result.toString();
        
    }
}