// https://leetcode.com/problems/number-of-matching-subsequences

class Solution {
    public int numMatchingSubseq(String S, String[] words) {
               
        Map<String, Integer> wordMap = new HashMap<>();
        for(String word : words)
            wordMap.put(word, wordMap.getOrDefault(word, 0)+1);
        
        int count = 0;
        for(String word : wordMap.keySet()){            
            if(isSubsequence(S, word)){
                count += wordMap.get(word);
            }
        }
        return count;
        
    }
    
    public boolean isSubsequence(String s, String sub){
        if(sub.length() > s.length())
            return false;
        int i = 0, j = 0;
        while(i < s.length() && j < sub.length()){
            if(s.charAt(i) == sub.charAt(j)){
                i++;
                j++;
            }
            else{
                i++;
            }
        }
        return j == sub.length();
    }
}