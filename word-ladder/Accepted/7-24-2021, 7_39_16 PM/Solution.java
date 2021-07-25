// https://leetcode.com/problems/word-ladder

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set=new HashSet<>();
        
        for(String s : wordList){
            set.add(s);
        }
        
        if(!set.contains(endWord))return 0;
        
        int depth=1;
        
        
        Queue<String> q=new LinkedList<>();
        q.offer(beginWord);
        
        while(!q.isEmpty()){
            
            int size=q.size(); //Size of current level
            
            for(int i=0;i<size;i++)
            {
                String current=q.poll();
                char[] curr=current.toCharArray();
                
                
                for(int j=0;j<curr.length;j++)
               {
                    char letter=curr[j];
                    for(char c='a';c<='z';c++)
                    {
                        if(c==letter)continue;
                        curr[j]=c;
                        String pathWord=String.valueOf(curr);
                        if(pathWord.equals(endWord)){
                            return depth+1;
                        }
                        if(set.contains(pathWord)){
                            q.offer(pathWord);
                            set.remove(pathWord);
                        }
                    }
                  curr[j]=letter;
               }
           }
            depth++;
    }
        return 0;
   }
}