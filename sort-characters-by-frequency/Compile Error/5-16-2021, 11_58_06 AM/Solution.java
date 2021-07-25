// https://leetcode.com/problems/sort-characters-by-frequency

class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> Map=new HashMap<Character,Integer>();
        
        for(char c : s.toCharArray())
        {
           Map.put(c,Map.getOrDefault(c,o)+1); //Jodi thake add one nahole set zeroadd one
        }
        
        PriorityQueue<Character> MaxHeap=new PriorityQueue<>((a,b)->Map.get(b)-Map.get(a)); //Priority queue constructed based on most frequently acquired
        
        
        MaxHeap.addAll(Map.keySet());
        
        StringBuilder result=new StringBuilder();
        while(!MaxHeap.isEmpty())
        {
            char current=MaxHeap.remove();
            for(int i=0;i<Map.get(current);i++)
             result.append(current);
        }
        return result;
    }
}