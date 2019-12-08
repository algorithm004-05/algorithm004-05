class Trie {
    boolean isEndOfWord = false;
    Trie[] next = new Trie[26];
    
    /** Initialize your data structure here. */
    public Trie() {
        
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] wordArray = word.toCharArray();
        Trie node = this;
        for (int i = 0;i < wordArray.length;i++) {
            if(node.next[wordArray[i] - 'a'] == null){
                node.next[wordArray[i] - 'a'] = new Trie();     
            }
            node=node.next[wordArray[i]-'a'];
            if(i == wordArray.length-1){
                node.isEndOfWord=true;
            } 
        }
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] wordArray = word.toCharArray();
        Trie node = this;
        for (int i = 0;i < wordArray.length;i++) {
            if(node.next[wordArray[i] - 'a'] == null){
                return false;
            }
            node=node.next[wordArray[i]-'a'];
        }
        return node.isEndOfWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] wordArray = prefix.toCharArray();
        Trie node = this;
        for (int i = 0;i < wordArray.length;i++) {
            if(node.next[wordArray[i] - 'a'] == null){
                return false;
            }
            node=node.next[wordArray[i]-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
