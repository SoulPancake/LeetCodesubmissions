// https://leetcode.com/problems/count-items-matching-a-rule

class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        HashMap<String,Integer> map=new HashMap<>();
        map.put("type",0);
        map.put("color",1);
        map.put("name",2);
        int c=0;
         for(int i=0;i<items.size();i++)
         {
             if((items.get(i).get(map.get(ruleKey))).equals(ruleValue))c++;
         }
        return c;
    }
}