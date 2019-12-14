import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by panda on 2019/12/1.
 */
public class LeetCode_146_430 {
    class LRUCache extends LinkedHashMap<Integer, Integer> {

        private int capacity;

        public LRUCache(int capacity) {
            // 使用accessOrder存储元素
            super(capacity, 0.75f, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return super.size() > capacity;
        }
    }
}
