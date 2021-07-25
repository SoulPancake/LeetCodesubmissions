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
    
    private boolean isSelfDividing(int num)
    {
        int pop = 0, copy = num;

       while(copy > 0) {
           pop = copy % 10;
           if(pop==0 || num%pop!=0)
              return false;

          copy /= 10;
           }

         return true;
    }
}