// https://leetcode.com/problems/self-dividing-numbers

class Solution {
    
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> l=new ArrayList<>();
        for(int i=left;i<=right;i++)
        {
            
                
            if(isSelfDividing(i))
                l.add(i);
        }
        return l;
    }
    
    private boolean isSelfDividing(int n)
    {
        for(char c : String.valueOf(n).toCharArray())
        {
            if(c=='0' || n%(c-'0')!=0)
                return false;
            
        }
     return true;
    }
}