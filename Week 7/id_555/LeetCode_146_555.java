package lsn17_bloomfilter_lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 146. LRU缓存机制
 * 
 * https://leetcode-cn.com/problems/lru-cache/
 */
public class LeetCode_146_555 {

	public static void main(String[] args) {
		LeetCode_146_555 leetcode = new LeetCode_146_555();
		LRUCache lCache = leetcode.new LRUCache(10);
	}

	class LRUCache extends LinkedHashMap<Integer, Integer> {

		private static final long serialVersionUID = 1L;
		
		private int capacity;

		public LRUCache(int capacity) {
			super(capacity, 0.75F, true);
			this.capacity = capacity;
		}

		public int get(int key) {
			return super.getOrDefault(key, -1);
		}

		public void put(int key, int value) {
			super.put(key, value);
		}

		@Override
		protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
			return size() > capacity;
		}
	}

}
