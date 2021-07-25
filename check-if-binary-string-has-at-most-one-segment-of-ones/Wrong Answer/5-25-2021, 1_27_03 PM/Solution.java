// https://leetcode.com/problems/check-if-binary-string-has-at-most-one-segment-of-ones

class Solution {
    public boolean checkOnesSegment(String s) {
        int indexWhereFirstZeroAppears=-1;
        for(int i=1;i<s.length();i++)
        {
            if(s.charAt(i)=='0')
                indexWhereFirstZeroAppears=i;
        }
        
        if(indexWhereFirstZeroAppears==-1)
            return true;
        
        for(int i=indexWhereFirstZeroAppears;i<s.length();i++)
        {
            if(s.charAt(i)=='1')
                return false;
        }
        
        return true;
    }
}