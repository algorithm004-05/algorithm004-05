class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Queue<String> q = new LinkedList<>();
        Set<String> words = new HashSet<>(wordList);
        Set<String> used = new HashSet<>();
        
        if(!words.contains(endWord)){
            return 0;
        }
        
        int length = 1;
        q.offer(beginWord);
        
        while(!q.isEmpty()){
            int n = q.size();
            for(int i = 0; i < n; i++){
                String cur = q.poll();
                
                char[] s = cur.toCharArray();
                
                for(int k = 0; k < s.length; k++){
                    for(int j = 0; j < 26; j++){
                        char ch = (char)('a' + j);
                        
                        if(s[k] == ch){
                            continue;
                        }
                        
                        char old = s[k];
                        s[k] = ch;
                        
                        String next = new String(s);
                        
                        if (next.equals(endWord)) {
                            return length + 1;
                        }
                        
                        if (words.contains(next) && !used.contains(next)){
                            q.offer(next);
                            used.add(next);
                        }
                        
                        s[k] = old;
                    }
                }
                
            }
            
            length++;
        }
        
        return 0;
    }
}
