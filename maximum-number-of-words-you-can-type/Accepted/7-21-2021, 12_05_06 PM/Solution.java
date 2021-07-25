// https://leetcode.com/problems/maximum-number-of-words-you-can-type

class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] a=text.split(" ");
        HashSet<Character> set=new HashSet<>();
        
        for(char c : brokenLetters.toCharArray()){
            set.add(c);
        }
        int count=0;
        
        for(String c : a){
            boolean invalid=false;
            for(char d : c.toCharArray()){
                if(set.contains(d)){
                    invalid=true;
                    break;
                }
            }
            if(!invalid)count++;
        }
        return count;
    }
}