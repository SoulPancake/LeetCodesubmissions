// https://leetcode.com/problems/combinations

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> al = new ArrayList<Integer> ();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        dfs(n,k,al,res,1);
        return new ArrayList(res);
        
    }
    public void dfs(int n, int k,List<Integer> al, List<List<Integer>> res,int index){
        if(al.size()==k){
             res.add(new ArrayList(al));
             return;
        }
       else{ 
           for(int i=index;i<=n;i++){
             al.add(i);
            dfs(n,k,al,res,i+1);
            al.remove(al.size()-1);
          }
    }
    }
}