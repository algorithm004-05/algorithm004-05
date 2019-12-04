/*
 * @lc app=leetcode.cn id=146 lang=cpp
 *
 * [146] LRUç¼“å­˜æœºåˆ¶
 */

// @lc code=start
class LRUCache {
    public:
    LRUCache(int capacity)
        : _capacity(capacity) {}

    int get(int key)
    {
        auto it = cache.find(key);
        if (it == cache.end()) {  //没有找到
            return -1;
        }
        touch(it);
        return it->second.first;
    }

    void put(int key, int value)
    {
        auto it = cache.find(key);
        if (it != cache.end()) {  //找到了
            touch(it);
        }
        else {
            if (cache.size() == _capacity) {
                cache.erase(used.back());
                used.pop_back();
            }
            used.push_front(key);
        }
        cache[key] = {value, used.begin()};
    }

    private:
    typedef list<int> LI;
    typedef pair<int, LI::iterator> PII;
    typedef unordered_map<int, PII> HIPII;

    void touch(HIPII::iterator it)
    {
        int key = it->first;
        used.erase(it->second.second);
        used.push_front(key);
        it->second.second = used.begin();
    }

    HIPII cache;
    LI used;
    int _capacity;
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */
 
 /*
 Accepted
18/18 cases passed (204 ms)
Your runtime beats 36.2 % of cpp submissions
Your memory usage beats 28.93 % of cpp submissions (40.2 MB)
 */