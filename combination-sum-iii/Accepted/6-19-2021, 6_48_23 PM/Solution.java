// https://leetcode.com/problems/combination-sum-iii

class Solution {
    public List<List<Integer>> combinationSum3(int size, int target) {
        int arr[]=new int[9];
        for(int i=0;i<9;i++){
            arr[i]=i+1;
        }
        
        return combine(arr,target,size);
    }
    
    
    //using k as target and n as size
    public List<List<Integer>> combine(int arr[], int k,int n) {
        ans=new ArrayList<List<Integer>>();
        solve(arr,0,new ArrayList<>(),k,n);
        return ans;
    }
    
    ArrayList<List<Integer>> ans;
    
    public void solve(int arr[],int idx,ArrayList<Integer> l,int k,int n){
        if(arr.length==idx){
            if(k==0&&l.size()==n){
                ans.add(new ArrayList<>(l));    
            }
            return;
        }
        
        
        int x=arr[idx];
        
        //yes call =>element will appear
        l.add(x);
        solve(arr,idx+1,l,k-x,n);
        l.remove(l.size()-1);
        
        //no call =>element will not appear
        solve(arr,idx+1,l,k,n);
    }
}