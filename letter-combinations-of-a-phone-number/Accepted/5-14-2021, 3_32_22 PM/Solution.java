// https://leetcode.com/problems/letter-combinations-of-a-phone-number

class Solution {
    public List<String> letterCombinations(String digits) {
       List<String> Result=new ArrayList<String>();
        
        if(digits==null || digits.length()==0)
            return Result;
        
        String[] mappings={
            "0",
            "1",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
        };
        
        LetterCombinationsRecursive(Result,digits,"",0,mappings);
        return Result;
        
    }
    
    public void LetterCombinationsRecursive(List<String> result,String digits,String current,int index,String[] mappings)
    {
        if(index==digits.length())
        {
            result.add(current);
            return;
        }
        
        String letters=mappings[digits.charAt(index)-'0'];
        for(int i=0;i<letters.length();i++)
        {
           LetterCombinationsRecursive(result,digits,current+letters.charAt(i),index+1,mappings);
        }
        
    }
}