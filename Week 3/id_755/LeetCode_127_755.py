class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        def key_generator(word):
            key_lst = []
            for i in range(len(word)):
                key_lst.append(word[:i] + "*" + word[i + 1:])
            return key_lst

        def bfs(word):
            queue = collections.deque()
            level = 1
            queue.append((word, level))
            while queue:
                word, level = queue.popleft()
                visited.add(word)
                key_lst = key_generator(word)
                for key in key_lst:
                    for next_word in key_word_dict[key]:
                        if next_word == endWord:
                            return level + 1
                        if next_word not in visited:
                            queue.append((next_word, level + 1))
            return 0

        if endWord not in wordList:
            return 0
        # build key-word map
        key_word_dict = collections.defaultdict(list)
        for word in wordList:
            key_lst = key_generator(word)
            for key in key_lst:
                key_word_dict[key].append(word)

        visited = set()
        return bfs(beginWord)
