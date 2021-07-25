// https://leetcode.com/problems/verifying-an-alien-dictionary

class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        
        int [] ary = new int[26];
    for(int i = 0; i < 26; i++){
        ary[order.charAt(i) - 'a'] = i;
    }
    int j = 0, index = 0, length = words.length;
    while(j + 1 < length){
        if(ary[words[j].charAt(index) - 'a'] == ary[words[j + 1].charAt(index) - 'a']){
            int min = (words[j].length() < words[j + 1].length()) ? 
                words[j].length() : words[j + 1].length();
            for(index = 0; index < min; index++){
                if(ary[words[j].charAt(index) - 'a'] > ary[words[j + 1].charAt(index) - 'a']) 
                    return false;
            }
        }else if(ary[words[j].charAt(index) - 'a'] > ary[words[j + 1].charAt(index) - 'a']) 
            return false;
        if(index + 1 <= words[j].length() && 
           words[j].substring(0, index).equals(words[j + 1])) return false;
        index = 0;
        j++;
    }
    return true;
        
    }
}