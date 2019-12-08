package id_105;

public class Trie {




    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }


    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char cur = word.charAt(i);
            if (!node.containsKey(cur)) {
                node.put(cur, new TrieNode());
            }
            node = node.get(cur);
        }
        node.setEnd();
    }

    public TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char cur = word.charAt(i);
            if (node.containsKey(cur)) {
                node = node.get(cur);
            } else {
                return null;
            }
        }
        return node;
    }

    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null ;
    }



    public static class TrieNode {


        private TrieNode[] links;

        private final int R = 26;

        private boolean isEnd;

        public TrieNode() {
            this.links = new TrieNode[R];
        }

        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }

        public void put(char ch, TrieNode node) {
            links[ch - 'a'] = node;
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }

    }


    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));

        System.out.println(trie.search("app"));

        System.out.println(trie.startsWith("app"));

        trie.insert("app");

        System.out.println(trie.search("app"));


    }
}
