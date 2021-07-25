// https://leetcode.com/problems/counting-bits

class Solution {
    public int[] countBits(int n) {
        int[] answer=new int[n+1];
        answer[0]=0;
        for(int i=1;i<=n;i++)
        {
            answer[i]=binCout(i);
        }
        return answer;
        
        
    }

    private int binCout(int n)
    {
        int count=0;
        while(n>0)
        {
            int end=n%2;
            if(end==1)count++;
            
            n/=2;
        }
        return count;
    }
}