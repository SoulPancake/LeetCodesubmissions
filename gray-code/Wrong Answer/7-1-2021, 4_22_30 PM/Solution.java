// https://leetcode.com/problems/gray-code

class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result=new ArrayList<>();
        if(n==1)
        {
            result.add(0);
            result.add(1);
            return result;
        }
        
        List<Integer> prev=grayCode(n-1);
        
        
        for(int i=0;i<prev.size();i++)
        {
            //Number to binary to string 
            
            StringBuilder current=new StringBuilder("0"+Integer.toBinaryString(prev.get(i)));
            int v=Integer.parseInt(current.toString(),2);
            result.add(v);
        }
        
        for(int i=prev.size()-1;i>=0;i--)
        {
            //Number to binary to string 
            
            StringBuilder current=new StringBuilder("1"+Integer.toBinaryString(prev.get(i)));
            int v=Integer.parseInt(current.toString(),2);
            result.add(v);
        }
        
        return result;
    }
}