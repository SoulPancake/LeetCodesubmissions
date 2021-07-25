// https://leetcode.com/problems/verifying-an-alien-dictionary

class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        
      int[] alphabet=new int[26];
        
        for(int i=0;i<order.length();i++)
        {
            alphabet[order.charAt(i)-'a']=i; //Indexing lexicographically
        }
        
        for(int i=0;i<words.length;i++)
        {
            for(int j=1+1;j<words.length;j++)
            {
                int min=Math.min(words[i].length(),words[j].length());
                //smaller word's length
                
                for(int k=0;k<min;k++)
                {
                    char iChar=words[i].charAt(k);
                    char jChar=words[j].charAt(k);
                    if(alphabet[iChar-'a']<alphabet[jChar-'a'])
                        break;
                    else if(alphabet[jChar-'a']<alphabet[iChar-'a'])
                        return false;
                    else if(k==min-1 && words[i].length()<words[j].length())
                        return false;
                }
            }
        }
        return true;  
        
        
    }
}