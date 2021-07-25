// https://leetcode.com/problems/group-anagrams

class Solution {
  public List < List < String >> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>(strs.length);
        char[] counts = new char[26];
        for(int i = 0; i < strs.length; i++) {
            Arrays.fill(counts, '0');
            for(char c : strs[i].toCharArray()) {
                counts[c - 'a']++;
            }
            String key = new String(counts);
            if(!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }
  }
}