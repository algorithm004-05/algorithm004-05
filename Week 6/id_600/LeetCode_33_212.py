def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
	trie = {}
	
	for word in words:
		node = trie
		for char in word:
			node = node.setdefault(char, {})
		node['#'] = True

	def search(i, j, node, pre, visited):  
	
		if '#' in node: 
			res.add(pre)  
			
		for (di, dj) in ((-1, 0), (1, 0), (0, -1), (0, 1)):
			_i, _j = i+di, j+dj
			if -1 < _i < h and -1 < _j < w and board[_i][_j] in node and (_i, _j) not in visited:
				search(_i, _j, node[board[_i][_j]], pre+board[_i][_j], visited | {(_i, _j)})

	res, h, w = set(), len(board), len(board[0])
	for i in range(h):
		for j in range(w):
			if board[i][j] in trie:
				search(i, j, trie[board[i][j]], board[i][j], {(i, j)})
	return list(res)	