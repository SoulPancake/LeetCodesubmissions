// https://leetcode.com/problems/partition-labels

class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ListPartition=new ArrayList<>();
        
        int[] LastIndexes=new int[26];
        
        for(int i=0;i<s.length();i++)
        {
           LastIndexes[S.charAr(i)-'a']=i;
        }
        
        int i=0;
        while(i<s.length())
        {
            int end=LastIndexes[s.charAt(i)-'a'];
            int j=i+1;
            while(j!=end)
            {
                end=Math.max(end,LastIndexes[s.charAt[j++]-'a']);
            }
            ListPartition.add(end-i+1);
             i=j+1;
        }
          return ListPartition; 
    }
}



/* Partition the string into parts
such that each part contains some letters and those letters exist 
only in those parts and not in any other parts
So we have to return the minimum size of the partitions
so that each part fulfills this criteria */