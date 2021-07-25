// https://leetcode.com/problems/stone-game-vii

class Solution {
//     public int stoneGameVII(int[] stones) {
//         HashMap<Integer,Integer> map=new HashMap<>();
//         //mapping the indexes which are used to those that are not!
        
//         int wholeSum=0;
      
//         for(int i=0;i<stones.length;i++)
//          {   map.put(i,0); //All the indexes are unused!
//             wholeSum+=stones[i];}
        
//         return solve(wholeSum,stones,0,stones.length1-1);
        
      
        
        
        
//     }
    
    public int stoneGameVII(int[] stones) {
    int n = stones.length;
    int[] dp = new int[n];
    for(int i = n - 1; i >= 0; i--) {
        for(int j = i + 1, sum = stones[i]; j < n; j++) {
            sum += stones[j];
            dp[j] = Math.max(sum - stones[i] - dp[j], sum - stones[j] - dp[j - 1]);
        }
    }
    return dp[n - 1];
}
//     private int solve(int wholeSum,int[] stones,int left,int right)
//     {
//         if(left==right)
//             return 0;
        
//         return Math.max
//     }
}

// Do not choose the maximum at each step greedily!!!
//   1   2   3
//   5  or 3   Choose 5 Alice 
//   2  3           
//   choose 2 to get 3 Bob
//   choose 3 to get 0 Alice
//Difference =2

  
//         int[] dp=new int[stones.length+1];
//         dp[0]=0; //No Elements!
        
//         dp[1]=0; //One element removed by Alice so the score difference is 0
    
         
//         dp[2]=Math.max(stones[1],stones[0]);