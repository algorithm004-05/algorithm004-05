"""
实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。

示例:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // 返回 true
trie.search("app");     // 返回 false
trie.startsWith("app"); // 返回 true
trie.insert("app");
trie.search("app");     // 返回 true
说明:

你可以假设所有的输入都是由小写字母 a-z 构成的。
保证所有输入均为非空字符串。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/implement-trie-prefix-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""


class Trie:

    def __init__(self):
        self.root = {}
        self.end_of_word = "#"

        """
        Initialize your data structure here.
        """

    def insert(self, word: str) -> None:
        node = self.root
        for c in word:
            node = node.setdefault(c,{})
        node[self.end_of_word] =  self.end_of_word
        """
        Inserts a word into the trie.
        """

    def search(self, word: str) -> bool:
        node = self.root
        for c in word:
            if c not in node:
                return False
            node = node[c]
        return self.end_of_word in node
        """
        Returns if the word is in the trie.
        """

    def startsWith(self, prefix: str) -> bool:
        node = self.root
        for c in prefix:
            if c not in node:
                return False
            node = node[c]
        return True
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """

    def search1(self, word: str) -> bool:
        return self.check(word,self.root)

    def check(self, word: str,node):
        if node == "#":
            return False
        for i,c in enumerate(word):
            if c == ".":
                for n in node.values():
                    if self.check(word[i+1:],n):
                        return self.end_of_word in node
            if c not in node:
                return False
            node = node[c]
        return self.end_of_word in node

# Your Trie object will be instantiated and called as such:
trie =  Trie();
print(trie.insert("apple"))
print(trie.search("apple"))  # 返回 true
print(trie.search("app"))     # 返回 false
print(trie.startsWith("app")) # 返回 true
print(trie.search1("ap.p."))
print(trie.search1("app.."))
print(trie.search1(".pp.e"))
print(trie.search1("."))