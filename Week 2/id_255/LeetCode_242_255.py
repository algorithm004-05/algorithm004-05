# 242. 有效的字母异位词
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s)!=len(t):
            return False
        s_set=set(s)  # 自带去重功能
        
        for ch in s_set:
            # 判断是否存在异词
            if ch not in s_set:
                return False
            # 判断是否数量相等
            if s.count(ch)!=t.count(ch):
                return False            
        return  True
    
        # # 定义默认布尔值参与后续运算
        # result = True
        # # 利用 Python 数据结构 set 去重去序
        # set_tmp = set(s)
        # # 先判断组成字符串的各个字符元素是否一致
        # if set_tmp == set(t):
        #     for i in set_tmp:
        #         # 利用逻辑运算符判断各个字符元素的数量一致，均为 True 才输出 True
        #         result = result and (s.count(i) == t.count(i))
        # else:
        #     result = False
        # return (result)