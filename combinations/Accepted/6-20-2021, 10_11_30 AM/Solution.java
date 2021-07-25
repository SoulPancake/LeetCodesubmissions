// https://leetcode.com/problems/combinations

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result=new ArrayList<>();
        
        backtrack(1,n,k,new ArrayList<>(),result);
        return result;
    }
    
    private void backtrack(int number,int max,int k,List<Integer> current,List<List<Integer>> result)
    {
        if(number>max)
        {
            if(k==0)
            {
                result.add(new ArrayList<>(current));
                
            }
            return;
        }
        if(k==0)
        {
            result.add(new ArrayList<>(current));
            return;
        }
        if(k<0)return;
        
        current.add(number);
        backtrack(number+1,max,k-1,current,result); //Simulating taking this current number
        current.remove(current.size()-1);
        
        
        backtrack(number+1,max,k,current,result);//simulating not taking the current number
        return;
        
    }
}