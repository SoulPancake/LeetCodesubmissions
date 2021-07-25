// https://leetcode.com/problems/rank-transform-of-an-array

class Solution {
 public int[] arrayRankTransform(int[] arr) {
        int a[]=new int[arr.length];
        HashMap<Integer,Integer> map=new HashMap<>();
        int ans[]=new int[arr.length];
        int rank=1;
        for(int i=0;i<arr.length;i++)
            a[i]=arr[i];
        Arrays.sort(a);
        for(int i:a)
        {
            if(!map.containsKey(i))
            {
                map.put(i,rank);
                rank++;
            }
        }
        for(int i=0;i<arr.length;i++)
        {
            ans[i]=map.get(arr[i]);
        }
        return ans;
    }
    
}