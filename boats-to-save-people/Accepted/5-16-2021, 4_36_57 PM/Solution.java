// https://leetcode.com/problems/boats-to-save-people

//Minimum number of boats
//SO greedy?
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people); //nlogn
        
        int numBoats=0;
        //Two pointers
        int i=0; //The lightest person
        int j=people.length-1; //The heaviest person (me)
        
        while(i<=j) //We haven't saved everyone until these pointers meet
        {
            if(people[i]+people[j]<=limit)
            {
                
                i++;
                j--;
            }else
            {
                //If there is a heavy person and the light person
                // does not fit in with him then we have to choose
                //only the heavier person and increment the number of boats
                j--;
            }
            numBoats++;
        }
        return numBoats;
    }
}