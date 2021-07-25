// https://leetcode.com/problems/find-kth-largest-xor-coordinate-value

class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        //Max heap
        
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        
        int xor=matrix[0][0];
        pq.offer(xor);
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[i].length;j++)
            {
                if(!(i==0 && j==0)){
                    xor^=matrix[i][j];
                    pq.offer(xor);
                }
            }
        }
        int a=0;
        for(int i=0;i<k;i++)
            a=pq.poll();
        
        return a;
    }
}