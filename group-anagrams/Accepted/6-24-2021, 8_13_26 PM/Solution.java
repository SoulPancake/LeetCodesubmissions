// https://leetcode.com/problems/group-anagrams

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
     List<List<String>> groupedAnagrams=new ArrayList<>();
        
     HashMap<String,List<String>> map=new HashMap<>();
        
        for(String str : strs)
        {
            char[] cur=str.toCharArray();
            Arrays.sort(cur);
            String sorted=new String(cur);
            if(!map.containsKey(sorted))
            {
                map.put(sorted,new ArrayList<>());
                
            }
            
            map.get(sorted).add(str);
        }
        
        
     groupedAnagrams.addAll(map.values());
        
        return groupedAnagrams;
    }
}