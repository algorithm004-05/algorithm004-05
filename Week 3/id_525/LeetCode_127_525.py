from collections import defaultdict


class Solution(object):
    def ladderLength(self, beginWord, endWord, wordList):
        """
        :type beginWord: str
        :type endWord: str
        :type wordList: List[str]
        :rtype: int
        """
        if not beginWord or not endWord or not wordList or endWord not in wordList:
            return 0
        b_len = len(beginWord)
        graph = defaultdict(list)
        for word in wordList:
            for i in range(b_len):
                graph[word[:i] + '*' + word[i + 1:]].append(word)
        visitd = {beginWord}
        queue = [(beginWord, 1)]
        while queue:
            current_word, level = queue.pop(0)
            for i in range(b_len):
                for word in graph[current_word[:i] + '*' + current_word[i + 1:]]:
                    if word == endWord:
                        return level + 1
                    if word not in visitd:
                        queue.append((word, level + 1))
                        visitd.add(word)
        return 0


class Solution2(object):
    def ladderLength(self, beginWord, endWord, wordList):
        """
        :type beginWord: str
        :type endWord: str
        :type wordList: List[str]
        :rtype: int
        """
        if not beginWord or not endWord or not wordList or endWord not in wordList:
            return 0
        graph = defaultdict(list)
        b_len = len(beginWord)
        # 生成一个临界表
        for word in wordList:
            for i in range(b_len):
                graph[word[:i] + '*' + word[i + 1:]].append(word)
        visited_begin = {beginWord: 1}
        visited_end = {endWord: 1}
        queue_begin = [(beginWord, 1)]
        queue_end = [(endWord, 1)]

        def find(queue, visited, other_visited):
            current_word, level = queue.pop(0)
            for i in range(b_len):
                for word in graph[current_word[:i] + '*' + current_word[i + 1:]]:
                    # 说明同时遇到了改节点即为目标节点。
                    if word in other_visited:
                        return level + other_visited[word]
                    if word not in visited:
                        visited[word] = level + 1
                        queue.append((word, level + 1))
            return None

        while queue_begin and queue_end:
            result = find(queue_begin, visited_begin, visited_end)
            other_result = find(queue_end, visited_end, visited_begin)
            if result is not None or other_result is not None:
                return result or other_result
        return 0


if __name__ == '__main__':
    s = Solution2()
    print(s.ladderLength('hot', 'dog', ['hot', 'dog', 'dot']))
