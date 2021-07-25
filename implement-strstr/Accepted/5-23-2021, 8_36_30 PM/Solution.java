// https://leetcode.com/problems/implement-strstr

class Solution {
    public int strStr(String haystack, String needle) {
        
       int startIndex = -1;
    
    if(needle.length() == 0){
        return 0;
    }
    
    if(!haystack.contains(needle)){
        
        return -1;
    }
    
    int j = 0;
    for(int i =0;i<haystack.length();i++){
        
        startIndex = i;
        while(needle.charAt(j) == haystack.charAt(i)){
                
                startIndex = Math.min(i, startIndex);

                if((needle.length()-1) == j){
                    
                    return startIndex;                        
                }
                else{
                    j++;
                    i++;
                     
                    if(needle.charAt(j) != haystack.charAt(i)){
                    
                        i = startIndex;
                        j = 0;                      
                        break;
                    
                    }   
                }      
        }         
    }
    return startIndex;
    }
}