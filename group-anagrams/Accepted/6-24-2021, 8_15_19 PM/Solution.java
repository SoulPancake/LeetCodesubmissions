// https://leetcode.com/problems/group-anagrams

class Solution {
  public List < List < String >> groupAnagrams(String[] strs) {
    Map < String, List < String >> map = new HashMap < > ();
 
    for (String s: strs) {
      String code = getCode(s);
      if (map.get(code) == null) map.put(code, new ArrayList());
      map.get(code).add(s);
    }
 
    return new ArrayList(map.values());
  }
 
  public String getCode(String s) {
    char carr[] = s.toCharArray();
    Arrays.sort(carr);
    return String.valueOf(carr);
  }
}