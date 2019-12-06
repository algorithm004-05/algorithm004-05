# solution 1 based on teacher's code
# each node in the trie is implemented by a dictionary
class Trie:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = {}
        self.end_word = "#"

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        node = self.root
        for char in word:
            node = node.setdefault(char, {})
        node[self.end_word] = self.end_word

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        node = self.root
        for char in word:
            # don't use 
            # if not node[char], this is not hash map implemented by an array!
            # use `in` to check existence but not directly access the char in dictionary
            if char not in node:
                return False
            node = node[char]
        return self.end_word in node

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        node = self.root
        for char in prefix:
            if char not in node:
                return False
            node = node[char]
        return True

# solution 2
# based on problem description, all chars range from a to z
# so the dictionary can be replaced by an arrray with a length of 26 (a~z) + 1 (end flag)
class node:
    def __init__(self):
        self.char_map = [None] * 27
        
class Trie:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = node()
        self.end_word = "#"

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        curr_node = self.root
        for char in word:
            index = ord(char) - ord("a")
            # very important which differs from the dict implementation
            # without this condition check, the node -> char already created will be replaced by a new node
            if not curr_node.char_map[index]:
                curr_node.char_map[index] = node()
            curr_node = curr_node.char_map[index]
        curr_node.char_map[-1] = self.end_word

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        curr_node = self.root
        for char in word:
            index = ord(char) - ord("a")
            if not curr_node.char_map[index]:
                return False
            curr_node = curr_node.char_map[index]
        return curr_node.char_map[-1] == self.end_word

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        curr_node = self.root
        for char in prefix:
            index = ord(char) - ord("a")
            if not curr_node.char_map[index]:
                return False
            curr_node = curr_node.char_map[index]
        return True


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
