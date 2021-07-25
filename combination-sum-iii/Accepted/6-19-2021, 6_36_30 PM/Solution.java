// https://leetcode.com/problems/combination-sum-iii

class Solution {
// list to store the final result
	 List<List<Integer>> list=new ArrayList<>();
	  public List<List<Integer>> combinationSum3(int k, int n) {
	  // if k>n then there is no solution and sum of all numbers from 1 to 9
	  // is  45 so if n>45 the solution is not possible
		  if(k>n  || n>45) {
			  return list;
		  }
		  helper(k,n,new ArrayList<>(),1,0);
		  return list;
	        
	    }
		
		// helper method to perform backtracking
	  public void helper(int k,int n,ArrayList<Integer> currentList,int number,int sum) {
	  
		  // if the conditions are met then add the currentList int the final list of list's
		  if(sum==n && currentList.size()==k) {
			  list.add(new ArrayList<>(currentList));
			  return;
		  }
		  
		  //check if basic constraints are met and if not return
		  if(currentList.size()>k || number>9 || sum>n) {
			  return;
		  }
		  
		  // exclude the current number from the currentList 
		  helper(k,n,currentList,number+1,sum);
		  
		  // include the current number in the currentList
		  currentList.add(number);
		  helper(k,n,currentList,number+1,sum+number);
		  currentList.remove(currentList.size()-1);
		  return;
	  }
}