// https://leetcode.com/problems/group-anagrams

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramsMap = new HashMap<>();
        
        for(String str : strs){
            // Sort the characters of the current word
            char[] letters = str.toCharArray();
            Arrays.sort(letters);
            String sortedStr = new String(letters);
            
			// If the current sorted word is not available in the map, then add a new entry in the map
            anagramsMap.putIfAbsent(sortedStr, new ArrayList<>());
            anagramsMap.get(sortedStr).add(str);
        }
        return new ArrayList<>(anagramsMap.values());
    }
}