// https://leetcode.com/problems/minimum-domino-rotations-for-equal-row

class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        return Math.min(
         numSwaps(tops[0],tops,bottoms),
            Math.min(
            numSwaps(bottoms[0],tops,bottoms),
            Math.min(
            numSwaps(tops[0],bottoms,tops),numSwaps(bottoms[0],bottoms,tops)))
        );
        
        
    }
    
    private int numSwaps(int target,int[] A,int[] B)
    {
        int minSwaps=0;
        for(int i=0;i<A.length;i++)
        {
            if(A[i]!=target && B[i]!=target)
                return Integer.MAX_VALUE; //Because we want minimum so anyone which actually satisfies the cases should be returned that's why we are returning Integer.MAX_VALUE to show that this case is not favourable
            else if(A[i]!=target)
                 minSwaps++;
        }
        return minSwaps;
    }
}