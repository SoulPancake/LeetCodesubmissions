// https://leetcode.com/problems/interleaving-string

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        return  solve(s1,s2,s3,0,0,0); //Starting pointers
        
    }
    
    boolean solve(String a,String b,String c,int i,int j,int k)
    {
        
        int na=a.length();
        int nb=b.length();
        int nc=c.length();
        
        if(k==nc && i==na && j==nb)
            return true;
        else if(k==nc)
             return false;
        
        
        boolean result=false;
        if(i<na && a.charAt(i)==c.charAt(k))
        {
            res=res||solve(a,b,c,i+1,j,k+1);
        }
        if(j<nb && b.charAt(j)==c.charAt(k))
        {
            res=res||solve(a,b,c,i,j+1,k+1);
        }
        return res;
    }
}