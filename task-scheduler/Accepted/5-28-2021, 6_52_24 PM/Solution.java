// https://leetcode.com/problems/task-scheduler

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] charCounts=new int[26];
        
        for(char c : tasks)
             charCounts[c-'A']++;
        
        Arrays.sort(charCounts);
        
        int maxOccuringFreq=charCounts[25]-1;
        int idleSlots=maxOccuringFreq*n;
        
        for(int i=24;i>=0;i--)
        {
            idleSlots-=Math.min(maxOccuringFreq,charCounts[i]);
        }
        
        return idleSlots>0? idleSlots+tasks.length:tasks.length;
        
    }
}