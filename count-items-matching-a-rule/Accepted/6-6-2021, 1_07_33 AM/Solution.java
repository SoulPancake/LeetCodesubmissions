// https://leetcode.com/problems/count-items-matching-a-rule

class Solution {
   public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int k=0;
        if(ruleKey.equals("color")) k =1;
        if(ruleKey.equals("name")) k=2;
        int count =0;
        for(List<String> list : items){
            if(list.get(k).equals(ruleValue)) count++;
        }
        return count;
    }
}