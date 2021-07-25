// https://leetcode.com/problems/k-th-symbol-in-grammar

class Solution {
    public int kthGrammar(int n, int k) {
        
       StringBuilder s=new StringBuilder("0");
        if(n==1)return Integer.parseInt(s.toString());
        
        for(int i=0;i<n;i++)
        {
            s=new StringBuilder(s.toString().replaceAll("0","a"));
            s=new StringBuilder(s.toString().replaceAll("1","b"));
            s=new StringBuilder(s.toString().replaceAll("a","01"));
            s=new StringBuilder(s.toString().replaceAll("b","10"));
        }
        return s.charAt(k-1)-'0';
    }
}