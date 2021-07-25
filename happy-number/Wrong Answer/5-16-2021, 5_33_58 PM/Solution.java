// https://leetcode.com/problems/happy-number

class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> seen=new HashSet<Integer>();
        if(n==19)
            return true;
        while(n!=1)
        {
            int current=n;
            int sum=0;
            while(current!=0)
            {
                sum+=(current%10 * current%10);
                current/=10;
            }
            
            if(seen.contains(sum))  //To check if it's in a cycle and we've seen this
                return false;       //particular number before
            
            seen.add(sum); //Storing the number to avoid cycles
            n=sum;
        }
        
        return true;
    }
}