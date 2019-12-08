/*
 * @lc app=leetcode.cn id=146 lang=cpp
 *
 * [146] LRU缓存机制
 */

// @lc code=start

class LRUCache {
private:
    int cap;
    list<pair<int, int>> cache;
    unordered_map<int, list<pair<int, int>>::iterator> map;
public:
    LRUCache(int capacity) {
        this->cap = capacity; 
    }
    
    int get(int key) {
        auto it = map.find(key);
        if (it == map.end()) return -1;
        pair<int, int> kv = *map[key];
        cache.erase(map[key]);
        cache.push_front(kv);
        map[key] = cache.begin();
        return kv.second; // value
    }
    
    void put(int key, int value) {

        auto it = map.find(key);
        if (it == map.end()) {
            if (cache.size() == cap) {
                auto lastPair = cache.back();
                int lastKey = lastPair.first;
                map.erase(lastKey);
                cache.pop_back();
            }
            cache.push_front(make_pair(key, value));
            map[key] = cache.begin();
        } else {
            cache.erase(map[key]);
            cache.push_front(make_pair(key, value));
            map[key] = cache.begin();
        }
    }
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */
// @lc code=end

