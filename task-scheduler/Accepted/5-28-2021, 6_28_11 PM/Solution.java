// https://leetcode.com/problems/task-scheduler

class Solution {
    public int leastInterval(char[] tasks, int n) {
        //Since it is only capital letters we can use array with relative indexing to
        //Keep the character counts
        
        int[] charMaps=new int[26]; //Only uppercase letters
        
        for(char c : tasks)
            charMaps[c-'A']++; //Relative indexing 0 to 26 A to Z
        
        
        //Now we will sort the charMaps array so that we can retrieve
        //The maximum occuring tasks' frequency
        
        Arrays.sort(charMaps);
        int max=charMaps[25]-1; //On the very last task we do not need to wait or stay idle //0 to 25
        int idleSlots=max*n; //For each character we have n idle slots
        
        for(int i=24;i>=0;i--)
        {
            idleSlots-=Math.min(charMaps[i],max);
            if(charMaps[i]==0)
                break;
        }
        
        
        return idleSlots>0?idleSlots+tasks.length:tasks.length;
           
    }
}