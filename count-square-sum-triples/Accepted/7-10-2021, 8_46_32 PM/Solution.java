// https://leetcode.com/problems/count-square-sum-triples

class Solution {
    public int countTriples(int n) {
        if(n<4)return 0;
        int[] a=new int[n];
        for(int i=0;i<n;i++)
            a[i]=(i+1)*(i+1);
        int count=0;
        for(int i=a.length-1;i>=2;i--)
        {
            int c=a[i]; //Fixed last element
            
            int left=0;
            int right=i-1;
            
            while(left<right)
            {
                if(c==a[left]+a[right])
                {
                    count+=2; //Left and right can be interchanged
                    left++;
                    right--;
                 }else if(c<a[left]+a[right])
                {
                    right--;
                }else
                {
                    left++;
                }
            }
        }
        
        return count;
        
    }
}