// https://leetcode.com/problems/max-consecutive-ones

class Solution {
    public int findMaxConsecutiveOnes(int[] arr) {
       int count=0;
int ans=0;
for(int i=0;i<arr.length;i++)
{
if(arr[i]==0)
{
count=0;
}
else
{
count++;
}

        if(count>ans)
        {
            ans=count;
        }
    }
    return ans;
    }
}