// https://leetcode.com/problems/find-words-that-can-be-formed-by-characters

class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] availableCharacters=new int[26];
        
        for(char c : chars.toCharArray())
             availableCharacters[c-'a']++;
        
        
        int count=0;
        for(int i=0;i<words.length;i++)
        { int[] charactersRequired=new int[26];
            for(char c : words[i].toCharArray())
            {
               charactersRequired[c-'a']++;
            }
          
         
           boolean possible=true;
           for(int p=0;p<26;p++)
           {
               if(charactersRequired[p]>availableCharacters[p])
                   {possible=false;break;}
           }
         if(possible)count+=words[i].length();
        }
        return count;
    }
}