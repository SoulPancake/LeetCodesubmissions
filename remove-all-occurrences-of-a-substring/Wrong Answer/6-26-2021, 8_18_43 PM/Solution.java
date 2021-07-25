// https://leetcode.com/problems/remove-all-occurrences-of-a-substring

class Solution {
    public String removeOccurrences(String s, String part) {
    
        StringBuilder g=new StringBuilder(s);
    
          while(g.toString().contains(part))
              g=new StringBuilder(g.toString().replaceAll(part,""));
        
        return g.toString();
    }
}