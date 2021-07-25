// https://leetcode.com/problems/string-compression

class Solution {
    public int compress(char[] chars) {
        
    
        int index=0;
        int i=0;
        while(i<chars.length())
        {
            int j=i;
            while(j<chars.length() && chars[j]==chars[i] )
            {
                j++;
            }
              chars[index++]=chars[i];
              if(j-i>1)
              {
                  String count=j-i+"";
                  //Now we have to go through every character in the count 
                  //to account for multiple digit long frequency
                  for(char c : count.toCharArray())
                  {
                       chars[index++]=c;
                  }
                  
                      
              }
            i=j;
        }
        return index;
    }
}