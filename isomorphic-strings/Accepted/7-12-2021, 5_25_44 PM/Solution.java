// https://leetcode.com/problems/isomorphic-strings

class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> map=new HashMap<>();
        HashSet<Character> used=new HashSet<>();
        
        if(s.length()!=t.length())
            return false;
        
         for(int i=0;i<s.length();i++)
         {
             if(map.containsKey(s.charAt(i)))
             {
                 if(t.charAt(i)==map.get(s.charAt(i)))
                 {
                     continue;
                 }else return false; 
             }else{
                 if(used.contains(t.charAt(i)))
                 {
                     return false;
                 }else{
                     map.put(s.charAt(i),t.charAt(i));
                     used.add(t.charAt(i));
                 }
             }
         }
        
        return true;
    }
}