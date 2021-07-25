// https://leetcode.com/problems/unique-email-addresses

class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> set=new HashSet<String>();
        for(String email : emails)
        {
           StringBuilder address=new StringBuilder();
            for(int i=0;i<email.length();i++)
            {
                char c=email.charAt(i);
                if(c=='.')
                {
                    continue;
                }else if(c=='+')
                {
                    while(email.charAt(i)!='@')
                    {
                        i++;
                    }
                    
                     address.append(email.substring(i));
                     break;//After the hash all the string is copied as it is
                //To avoid the .com's " . " to be eliminated
                    
                }else
                    address.append(c);
            }
            
            set.add(address.toString());
        }
        return set.size();
        
    }
}