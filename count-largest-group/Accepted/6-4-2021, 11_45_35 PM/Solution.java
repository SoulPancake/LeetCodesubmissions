// https://leetcode.com/problems/count-largest-group

class Solution {
    public int countLargestGroup(int n) {
        HashMap<Integer,Integer> map=new HashMap<>();
            //A certain sum,Number of numbers
        for(int i=1;i<=n;i++)
        {
            int sum=sumOfDigits(i);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        //I have to retrieve the number of keys for which the values are the max value
        //First let's find the max value
        int max=Integer.MIN_VALUE;
        for(int value : map.values())
        {
            if(value>max)max=value;
        }
        
        int count=0;
        for(int key : map.keySet())
        {
            if(map.get(key)==max)
                count++;
        }
        
        //Now we need to find the number of keys for which the value ==max
        
       return count; 
    }
    
    private int sumOfDigits(int n)
    {
        int sum=0;
        while(n>0)
        {
            sum+=n%10;
            n/=10;
        }
        return sum;
    }
}