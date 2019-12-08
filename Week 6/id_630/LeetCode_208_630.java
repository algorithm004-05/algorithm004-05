class Trie {

    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for(int i=0; i<word.length(); i++) {
            char key = word.charAt(i);
            if(!node.containsKey(key)) {
                node.putNode(key, new TrieNode());
            }
            node = node.getNode(key);
        }
        node.setEnd();
    }

    public TrieNode searchNode(String string) {
        TrieNode node = root;
        for(int i=0; i<string.length(); i++) {
            char key = string.charAt(i);
            if(node.containsKey(key)){
                node = node.getNode(key);
            }else {
                return null;
            }
        }
        return node;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = searchNode(word);
        return node != null && node.isEnd();

    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = searchNode(prefix);
        return node !=null;
    }
}

class TrieNode {
    private TrieNode[] links;

    private boolean isEnd;

    public TrieNode() {
        links = new TrieNode[26];
    }

    public void setEnd() {
        this.isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void putNode(char key, TrieNode node) {
        links[key - 'a'] = node;
    }

    public boolean containsKey(char key) {
        return links[key - 'a'] != null;
    }

    public TrieNode getNode(char key) {
        return links[key - 'a'];
    }

}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */