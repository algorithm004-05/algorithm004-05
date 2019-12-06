class Trie {

    private TreeNode root = new TreeNode();

    /**
     * Initialize your data structure here.
     */
    public Trie() {

    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TreeNode node = root;
        for (char c : word.toCharArray()) {
            if (!node.contains(c)) {
                node.insert(c);
            }
            node = node.get(c);
        }
        node.setEnd();
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TreeNode node = searchNode(word);
        return null != node && node.getEnd();
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TreeNode node = searchNode(prefix);
        return null != node;
    }

    private TreeNode searchNode(String prefix) {
        TreeNode node = root;
        for (char c : prefix.toCharArray()) {
            if (!node.contains(c)) {
                return null;
            }
            node = node.get(c);
        }
        return node;
    }

    class TreeNode {

        private TreeNode[] values = new TreeNode[26];
        private boolean isEnd;

        public TreeNode get(char c) {
            return values[c - 'a'];
        }

        public void insert(char c) {
            values[c - 'a'] = new TreeNode();
        }

        public boolean contains(char c) {
            return values[c - 'a'] != null;
        }

        public boolean getEnd() {
            return isEnd;
        }

        public void setEnd() {
            this.isEnd = true;
        }
    }

}