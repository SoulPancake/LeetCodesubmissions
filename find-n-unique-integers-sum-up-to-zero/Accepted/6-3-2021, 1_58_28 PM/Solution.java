// https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero

class Solution {
    public int[] sumZero(int n) {
        if(n%2==0)
        {
            int[] ret=new int[n];
            int i=0;
            int j=n-1;
            int k=1000;
            while(i<j)
            {
                ret[i]=k--;
                ret[j]=-(k+1);
                i++;
                j--;
            }
            return ret;
        }else
        {
            int[] ret=new int[n];
            int i=0;
            int j=n-1;
            int k=1000;
            while(i<j)
            {
                ret[i]=k--;
                ret[j]=-(k+1);
                i++;
                j--;
            }
            ret[j]=0;
            return ret;
        }
    }
}