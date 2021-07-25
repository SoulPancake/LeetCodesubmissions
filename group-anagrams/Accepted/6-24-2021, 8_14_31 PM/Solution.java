// https://leetcode.com/problems/group-anagrams

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
 if(strs == null || strs.length < 1) return null;
        List<List<String>> ans = new ArrayList<List<String>>();
        //each letter in alphabet has prime associated with it
        int[] primes = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        
        //For each word, create a product of primes from its letters
        HashMap<Long, ArrayList<String>> hs = new HashMap<>();
        
        for(String s : strs){
            long sum = 1;
            char[] c = s.toCharArray();
            
            for(char d : c){
                sum *= primes[d-'a'];
            }

            if(hs.containsKey(sum)){
                hs.get(sum).add(s);
            }else{
                hs.put(sum, new ArrayList<>());
                hs.get(sum).add(s);
            }
        }
        
        for(long l : hs.keySet()){
            ans.add(hs.get(l));
        }
        
        return ans;
    }
}