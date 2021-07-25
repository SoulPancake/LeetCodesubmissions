// https://leetcode.com/problems/string-compression

class Solution {
    public int compress(char[] chars) {
        
    
        char prev=chars[0];
        int count=0;
        StringBuilder bopa=new StringBuilder();
        int i;
       for(i=0;i<chars.length;i++)
       {
           if(chars[i]!=prev)
           {
               if(count==1)
                 bopa.append(chars[i-1]);
               else
               {
                   bopa.append(chars[i-1]);
                   bopa.append(count);
               }  
               
               prev=chars[i];
               count=1;//The letter is already at the index i
           }else
               count++;
           
         } 
        
               if(count==1)       //Last character jeta
                 bopa.append(chars[i-1]);
               else
               {
                   bopa.append(chars[i-1]);
                   bopa.append(count);
               } 
        int index=0;
       for(int i=0;i<bopa.length();i++)
       {
           chars[i]=bopa.charAt();
       }
        
        
        return bopa.length();
    }
}