// https://leetcode.com/problems/defanging-an-ip-address

class Solution {
    public String defangIPaddr(String address) {
        StringBuilder boma=new StringBuilder();
        
        for(char c: address.toCharArray())
        {
            if(c=='.')
            {
                boma.append("[.]");
            }else
                boma.append(c);
            
        }
        return boma.toString();
    }
}