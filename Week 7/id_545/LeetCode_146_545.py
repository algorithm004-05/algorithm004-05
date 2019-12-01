## 146. LRU缓存机制

class LRUCache:
    
    def __init__(self, capacity: int):
        self.dic = collections.OrderedDict()
        self.size = capacity

    def get(self, key: int) -> int:
        if key not in self.dic: return -1
        v = self.dic.pop(key)
        self.dic[key] = v
        return v

    def put(self, key: int, value: int) -> None:
        if key in self.dic:
            self.dic.pop(key)
        else:
            if len(self.dic) >= self.size:
                self.dic.popitem(last=False)
        self.dic[key] = value