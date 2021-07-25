// https://leetcode.com/problems/maximum-number-of-balloons

class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] charCounts=new int[26];//26 lowercase letters frequencies
        for(char c : text.toCharArray())
        {
            charCounts[c-'a']++;
        }
        
        int min=charCounts['b'-'a'];//Occurrences of the letter 'b'
        min=Math.min(min,charCounts['a'-'a'];//a
        min=Math.min(min,charCounts['l'-'a']/2);//ll
        min=Math.min(min,charCounts['o'-'a']/2);//oo
        min=Math.min(min,charCounts['n'-'a']);//n            
        
        
        return min;
        
    }
}