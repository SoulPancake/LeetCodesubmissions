// https://leetcode.com/problems/gray-code

class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> ans=new ArrayList<>();
        if(n==0)return ans;
        ans.add(0);ans.add(1);
        int len=2,i=2,k=2;
        while(i<=n)
        {
            for(int j=len-1;j>=0;j--)
            {
                ans.add(ans.get(j)+k);
                len++;
            }
            i++;
            k*=2;
        }
        return ans;
    }
}