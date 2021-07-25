// https://leetcode.com/problems/fruit-into-baskets

class Solution {
    public int totalFruit(int[] tree) {
        
        
        if(tree==null || tree.length==0)
             return 0;
        
        int max=1;
        
        HashMap<Integer,Integer> Map=new HashMap<Integer,Integer>();
        
        int i=0;
        int j=0;
        while(j<tree.length)
        {
            if(Map.size()<=2)
            {
                Map.put(tree[j],j++);
            }
            
            if(Map.size()>3)
            {
                int min=tree.length-1;
                for(int value : Map.values())
                {
                    min=Math.min(min,value);
                }
                i=min+1;
                Map.remove(tree[min]);
                
                max=Math.max(max,j-i);
            }
            
        }
        return max;
    }
}