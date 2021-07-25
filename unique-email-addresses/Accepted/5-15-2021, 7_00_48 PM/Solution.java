// https://leetcode.com/problems/unique-email-addresses

class Solution {
    public int numUniqueEmails(String[] emails) {
HashSet<String> set = new HashSet<>();
        for(String email : emails){
            StringBuilder stringBuilder = new StringBuilder();
            for(int i = 0; i < email.length(); i++){
                char temp = email.charAt(i);
                if(temp == '.'){
                    continue;
                }
                else if(temp == '+') {
                    while(email.charAt(i) != '@'){
                        i++;
                    }
                    stringBuilder.append(email.substring(i));
                    break;
                } else if(temp == '@') {
                	stringBuilder.append(email.substring(i));
                	break;
                }
                else {
                    stringBuilder.append(temp);
                }
            }
            set.add(stringBuilder.toString());
        }
        System.out.println(set.toString());
        return set.size();
    }
}