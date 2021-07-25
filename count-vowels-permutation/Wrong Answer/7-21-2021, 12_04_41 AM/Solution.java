// https://leetcode.com/problems/count-vowels-permutation

class Solution {
    private HashMap<String,Long> map=new HashMap<>();
    private int mod=1000000007;
    public int countVowelPermutation(int n) {
        char[] c=new char[]{'a','e','i','o','u'};
        long total=0;
        for(char d :  c){
            total=(total+helper(n-1,d))%mod;
        }
        
        return (int)total;
    }
    
    private long helper(int remChars,char previousCharacter)
    {
        if(remChars==0)return 1;
        String key=""+remChars+previousCharacter;
        if(map.containsKey(key))return map.get(key);
        
        long total=0;
        
        switch(previousCharacter){
            case 'a': total=(helper(remChars-1,'e'))%mod;
                      break;
            case 'e':total=(helper(remChars-1,'a')+helper(remChars-1,'i'))%mod;
                break;
            case 'i':total=(helper(remChars-1,'a')+helper(remChars-1,'e')+helper(remChars-1,'o')+helper(remChars,'u'))%mod;
                break;
            case 'o':total=(helper(remChars-1,'i')+helper(remChars,'u'))%mod;
                break;
            case 'u':total=(helper(remChars-1,'a'))%mod;
                break;
                
        }
        
        map.put(key,total);
        return total;
    }
}