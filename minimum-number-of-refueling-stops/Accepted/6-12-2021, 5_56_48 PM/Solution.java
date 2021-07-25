// https://leetcode.com/problems/minimum-number-of-refueling-stops

class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if(startFuel>=target)return 0;
        
        int xCurrent=startFuel; //Maximum distance we can reach with current amount of fuel in the tank!
        
        int noOfStops=0;
        
        PriorityQueue<Integer> maxAvailableFuelSoFar=new PriorityQueue<>((a,b)->(b-a));
        
        
        for(int[] station : stations)
        {
            int nextStation=station[0];
            int fuelInStation=station[1];
            
            while(xCurrent<nextStation)
            {
                if(maxAvailableFuelSoFar.isEmpty())
                    return -1;
                
              
                 xCurrent+=maxAvailableFuelSoFar.poll(); //Simulating adding the fuel to our tank!
                 noOfStops++;
                
            }
            maxAvailableFuelSoFar.offer(fuelInStation);
        }
        
        while(xCurrent<target)
        {
            if(maxAvailableFuelSoFar.isEmpty())
                    return -1;
                
              
                 xCurrent+=maxAvailableFuelSoFar.poll(); //Simulating adding the fuel to our tank!
                 noOfStops++;
        }
        
        return noOfStops;
    }
}