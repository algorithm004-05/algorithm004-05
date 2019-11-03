#@author:leacoder
#@des:  递归  电话号码的字母组合

"""
递归处理digits字符串中的每个字符
digits的每个字符又有多种情况（多个字母需要处理）
递归终止条件就是 digits字符串中的每个字符 已处理结束
"""

class Solution:
    phone = {'2': ['a', 'b', 'c'],
                 '3': ['d', 'e', 'f'],
                 '4': ['g', 'h', 'i'],
                 '5': ['j', 'k', 'l'],
                 '6': ['m', 'n', 'o'],
                 '7': ['p', 'q', 'r', 's'],
                 '8': ['t', 'u', 'v'],
                 '9': ['w', 'x', 'y', 'z']}
    output = [] # 输出
    def letterCombinations(self, digits: str) -> List[str]:
        
        # 字典 存储 每个数字对应的字母
        self.output = []
        if digits:
            self.recursive("",digits)	# "" 字母组合 最开始为"" , digits 待处理的字符串（处理后剩下的）
        return self.output


    #递归函数 
    # combination，上一层处理后的到的字母组合
    # next_digits，上层处理后剩余的字符串（本层需要处理的字符串）
    def recursive(self,combination , next_digits):
        if len(next_digits) == 0:	# 终止条件 字符串中的每个字母已处理结束
            self.output.append(combination)	# 将组合的字母组合存入output输出
            return
        else:
            for letter in self.phone[next_digits[0]]: # 处理 digits的每个字母 的多种情况
            	# combination + letter 将当前层处理的字母加入 字母组合
            	# next_digits[1:] 递归到 digits 字符串的下一个字符
                self.recursive(combination + letter,next_digits[1:])



#@author:leacoder
#@des:  迭代  电话号码的字母组合

"""
迭代digits字符串中每个字符num进行处理
遍历 phone[num] 中每个字母并加入现有结果中得到新的结果
digits字符串中num字符处理结束（phone[num] 中每个字母处理完成）更新现有结果
"""

class Solution:
    phone = {'2': ['a', 'b', 'c'],
                 '3': ['d', 'e', 'f'],
                 '4': ['g', 'h', 'i'],
                 '5': ['j', 'k', 'l'],
                 '6': ['m', 'n', 'o'],
                 '7': ['p', 'q', 'r', 's'],
                 '8': ['t', 'u', 'v'],
                 '9': ['w', 'x', 'y', 'z']}
    def letterCombinations(self, digits: str) -> List[str]:
        if not digits:
            return []

        output = [""] # 输出 初始 存储""
        for num in digits:	# 对digits字符串中每个字符进行处理
            tmplist=[]	# 中间变量
            for letter in self.phone[num]: # 遍历 phone[num] 每个字母进行处理
                for tmp in output:	# 遍历output向输出中添加新增的字母
                    # 注意 tmp + letter，tmp在前 因为新增的字母要加在后面
                    tmplist.append(tmp + letter)	
            output = tmplist # digits字符串中num字符处理结束（phone[num] 中每个字母处理完成）更新现有结果
        return output

"""
把代码块
for num in digits:	# 对digits字符串中每个字符进行处理
    tmplist=[]	# 中间变量
    for letter in self.phone[num]: # 遍历 phone[num] 每个字母进行处理
        for tmp in output:	# 遍历output向输出中添加新增的字母
            # 注意 tmp + letter，tmp在前 因为新增的字母要加在后面
            tmplist.append(tmp + letter)	
    output = tmplist # digits字符串中num字符处理结束（phone[num] 中每个字母处理完成）更新现有结果

可以精简为：
for num in digits:
	output =   [tmp + letter  for letter in self.phone[num] for tmp in output]
"""