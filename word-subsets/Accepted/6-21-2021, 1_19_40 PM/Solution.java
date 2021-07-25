// https://leetcode.com/problems/word-subsets

class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> result=new ArrayList<>();
        int[] maxFrequencies=new int[26];
        for(int i=0;i<words2.length;i++)
        {
            String currentWord=words2[i];
            int[] charFrequencies=getCharFrequencies(currentWord);
            
            for(int j=0;j<26;j++)
                maxFrequencies[j]=Math.max(maxFrequencies[j],charFrequencies[j]);
            
            
        }
        
        for(int i=0;i<words1.length;i++)
        {
            String CurrentWord=words1[i];
            int[] charFrequencies=getCharFrequencies(CurrentWord);
            boolean valid=true;
            for(int j=0;j<26;j++)
            {
                if(charFrequencies[j]<maxFrequencies[j])
                {
                    valid=false;
                    break;
                }
            }
            if(valid)result.add(CurrentWord);
        }
        
        return result;
    }
    
    private int[] getCharFrequencies(String S)
    {
        int[] result=new int[26];
        
        for(char c : S.toCharArray())
            result[c-'a']++;
        
        return result;
    }
}