// https://leetcode.com/problems/fraction-to-recurring-decimal

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb=new StringBuilder();
        
        int q=numerator/denominator;
        int r=numerator%denominator;
        
        sb.append(q);
        if(r==0)
            return sb.toString();
        else
            sb.append(".");
        
        HashMap<Integer,Integer> map=new HashMap<>();
        
        
        while(r!=0)
        { if(map.containsKey(r))
          {
            int l=map.get(r);
            sb.insert(l,"(");
            sb.append(")");
           }
         else{
              r*=10;
            q=r/denominator;
            r=r%denominator;
            sb.append(q);
             }
           
        }
            
        
        
        
        return sb.toString();
        
    }
}