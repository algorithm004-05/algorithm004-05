package week3;

import java.util.*;

/**
 * @auther: shizeying
 * @date: 2019/11/4 00:34
 * @description:
 */
public class leetcode_127 {
	/**
	 * 126
	 * 给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换需遵循如下规则：
	 * <p>
	 * 每次转换只能改变一个字母。
	 * 转换过程中的中间单词必须是字典中的单词。
	 * <p>
	 * 说明:
	 * <p>
	 * 如果不存在这样的转换序列，返回一个空列表。
	 * 所有单词具有相同的长度。
	 * 所有单词只由小写字母组成。
	 * 字典中不存在重复的单词。
	 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
	 * <p>
	 * 示例 1:
	 * 输入:
	 * beginWord = "hit",
	 * endWord = "cog",
	 * wordList = ["hot","dot","dog","lot","log","cog"]
	 * 输出:
	 * [
	 * ["hit","hot","dot","dog","cog"],
	 *   ["hit","hot","lot","log","cog"]
	 * ]
	 * <p>
	 * 示例 2:
	 * 输入:
	 * beginWord = "hit"
	 * endWord = "cog"
	 * wordList = ["hot","dot","dog","lot","log"]
	 * 输出: []
	 * 解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。
	 */
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		
		List<List<String>> res=new ArrayList<>();
		//含有非法单词
		if (!wordList.contains(endWord)) {
			return res;
		}
		findLaddersBfs(beginWord, endWord, wordList, res);
		
		return res;
	}
	
	private void findLaddersBfs(String beginWord, String endWord, List<String> wordList, List<List<String>> res) {
		Queue<List<String>> queue = new LinkedList<>();
		List<String> path = new ArrayList<>();
		path.add(beginWord);
		queue.offer(path);
		boolean isFound = false;
		Set<String> dict = new HashSet<>(wordList);
		Set<String> visited = new HashSet<>();
		visited.add(beginWord);
		while (!queue.isEmpty()) {
			int size = queue.size();
			Set<String> subVisited = new HashSet<>();
			for (int i = 0; i < size; i++) {
				List<String> p = queue.poll();
				//得到当前路径的末尾单词
				String temp = p.get(p.size() - 1);
				//一次性得到所有的下一个的节点
				ArrayList<String> neighbors = getNeighbors(temp, dict);
				for (String neighbor : neighbors) {
					//只考虑之气没有出现过的单词
					if (!visited.contains(neighbor)) {
						//到达结束的单词
						if (neighbor.equals(endWord)) {
							isFound = true;
							p.add(neighbor);
							res.add(new ArrayList<>(p));
							p.remove(p.size() - 1);
						}
						//加入当前单词
						p.add(neighbor);
						queue.offer(new ArrayList<>(p));
						p.remove(p.size() - 1);
						subVisited.add(neighbor);
					}
				}
			}
			visited.addAll(subVisited);
			if (isFound) {
				break;
			}
		}
	}
	
	private ArrayList<String> getNeighbors(String temp, Set<String> dict) {
		ArrayList<String> strings = new ArrayList<>();
		char[] chars = temp.toCharArray();
		for (char ch = 'a'; ch <= 'z'; ch++) {
			for (int i = 0; i < chars.length; i++) {
				if (chars[i] == ch) {
					continue;
				}
				char oldCh = chars[i];
				chars[i] = ch;
				if (dict.contains(String.valueOf(chars))) {
					strings.add(String.valueOf(chars));
				}
				chars[i]=oldCh;
			}
		}
		return strings;
	}
	
	/**
	 * 未优化
	 * @param beginWord
	 * @param endWord
	 * @param wordList
	 * @return
	 */
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> wordSet = new HashSet<>(wordList.size());
		wordSet.addAll(wordList);
		if (!wordSet.contains(endWord)) {
			return 0;
		}
		Set<String> s1 = new HashSet<>();
		Set<String> s2 = new HashSet<>();
		s1.add(beginWord);
		s2.add(endWord);
		int length = beginWord.length();
		int step = 0;
		while (!s1.isEmpty() && !s2.isEmpty()) {
			step++;
			if (s1.size() > s2.size()) {
				Set<String> tmp = s1;
				s1 = s2;
				s2 = tmp;
			}
			Set<String> set = new HashSet<>();
			for (String word : s1) {
				for (int i = 0; i < length; i++) {
					char[] chars = word.toCharArray();
					for (char ch = 'a'; ch <= 'z'; ch++) {
						chars[i] = ch;
						String tmp = new String(chars);
						if (s2.contains(tmp)) {
							return step + 1;
						}
						if (!wordSet.contains(tmp)) {
							continue;
						}
						wordSet.remove(tmp);
						set.add(tmp);
					}
				}
			}
			s1 = set;
		}
		return 0;
	}
	
	class Solution {
		/**
		 * 优化过后
		 * @param beginWord
		 * @param endWord
		 * @param wordList
		 * @return
		 */
		public int ladderLength(String beginWord, String endWord, List<String> wordList) {
			Set<String> words = new HashSet<>(wordList);
			Set<String> start = new HashSet<>();
			Set<String> end = new HashSet<>();
			start.add(beginWord);
			end.add(endWord);
			if(!words.contains(endWord)){
				return 0;
			}
			return bfs(start,end,words,2);
			
		}
		private int bfs(Set<String> start,Set<String> end,Set<String> words,int distance) {
			if(start.size() == 0){
				return 0;
			}
			if(start.size() > end.size()){
				return bfs(end,start,words,distance);
			}
			words.removeAll(start);
			Set<String> toAdd = new HashSet<>();
			for (String each : start) {
				char [] chars = each.toCharArray();
				for (int i = 0; i < chars.length; i++) {
					char temp = chars[i];
					for(char j = 'a'; j <= 'z';j++) {
						if(temp == j) continue;
						chars[i] = j;
						String word = new String(chars);
						if(words.contains(word)){
							if(end.contains(word)){
								return distance;
							}
							toAdd.add(word);
						}
					}
					chars[i] = temp;
				}
			}
			return bfs(toAdd,end,words,distance + 1);
		}
	}
	
	
}
