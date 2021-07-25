// https://leetcode.com/problems/rank-transform-of-an-array

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        HashMap<Integer,Integer> map=new HashMap<>();
        
        int[] copy=new int[arr.length];
        
        for(int i=0;i<arr.length;i++)
        {
            copy[i]=arr[i];
        }
        
        Arrays.sort(copy);
        int rank=1;
        for(int i : copy)
        {
            if(!map.containsKey(i))
            {
                map.put(i,rank++);
            }
        }
        
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=map.get(arr[i]);
        }
        return arr;
    }
}