// https://leetcode.com/problems/top-k-frequent-elements

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] freq=new int[100001];
        for(int num : nums)
            freq[num]++;
        List<Integer> l=new ArrayList<>();
        while(k>0)
        {
            int max=Integer.MIN_VALUE;
            int index=0;
            for(int i=0;i<100001;i++)
            {
               if(freq[i]>max)
                   max=freq[i];
            }
              for(int i=0;i<100001;i++)
            {
               if(freq[i]==max)
                  { index=i;freq[i]=Integer.MIN_VALUE;break;}
                   
            }
            l.add(index);
            k--;
        }
        
        int[] res=new int[l.size()];
        for(int i=0;i<l.size();i++)
            res[i]=l.get(i);
        
        return res;
        
    }
}