// https://leetcode.com/problems/escape-the-ghosts

class Solution {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int distanceForMaanush=Math.abs(target[1])+Math.abs(target[0]);
        
        for(int i=0;i<ghosts.length;i++)
        {
            int GhostDistanceFromTarget=Math.abs(ghosts[i][0]-target[0])+Math.abs(ghosts[i][1]-target[1]);
            
            if(GhostDistanceFromTarget<=distanceForMaanush)
                return false;
        }
        return true;
    }
}

//If ghost reaches the destination before you then he will definitely catch you!
//Calculate the Manhattan distance between the target and you and the target and all of the ghosts
//And If any of the ghosts can reach the target before you then it will definitely catch you
//Because unlike pacman you do not have free will and you want to fukcing die and not esacpe