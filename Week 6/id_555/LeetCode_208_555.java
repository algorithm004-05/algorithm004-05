package lsn13_tire_disjoint_set;

/**
 * 208. 实现 Trie (前缀树)
 * 
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/
 */
public class LeetCode_208_555 {

	public static void main(String[] args) {
		LeetCode_208_555 leetcode = new LeetCode_208_555();
		Trie trie = leetcode.new Trie();

		trie.insert("apple");
		System.out.println(trie.search("apple")); // 返回 true
		System.out.println(trie.search("app")); // 返回 false
		trie.startsWith("app"); // 返回 true
		trie.insert("app");
		System.out.println(trie.search("app")); // 返回 true

	}

	class Trie {
		private TrieNode root;

		public Trie() {
			root = new TrieNode();
		}

		public void insert(String word) {
			TrieNode node = root;
			for (int i = 0; i < word.length(); i++) {
				char currentChar = word.charAt(i);
				if (!node.containsKey(currentChar)) {
					node.put(currentChar, new TrieNode());
				}
				node = node.get(currentChar);
			}
			node.setEnd();
		}

		private TrieNode searchPrefix(String word) {
			TrieNode node = root;
			for (int i = 0; i < word.length(); i++) {
				char curLetter = word.charAt(i);
				if (node.containsKey(curLetter)) {
					node = node.get(curLetter);
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
			return node != null;
		}

	}

	class TrieNode {
		private TrieNode[] links;
		private final int R = 26;
		private boolean isEnd;

		public TrieNode() {
			links = new TrieNode[R];
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

}
