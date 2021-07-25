// https://leetcode.com/problems/shuffle-string

class Solution {
    public String restoreString(String s, int[] ind) {
        char[] arr=new char[ind.length];
        for(int i=0;i<s.length();i++)
        {
            arr[ind[i]]=s.charAt(i);
        }
        return String.valueOf(arr);
    }
}