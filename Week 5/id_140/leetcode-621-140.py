#
# @lc app=leetcode.cn id=621 lang=python3
#
# [621] 任务调度器
#

# @lc code=start
class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        res = 0
        #使用哈希表存储task的数量以便于查找
        hash_map = {}
        for task in tasks:
            hash_map[task] = hash_map.get(task, 0) + 1
        #出现次数最多的任务
        max_times = 0
        #出现次数一样多的任务数量
        num = 1
        for key in hash_map:
            if hash_map[key] > max_times:
                max_times = hash_map[key]
                num = 1
            elif hash_map[key] == max_times:
                num += 1
            else:
                continue
        #计算公式：
        res = (max_times-1) * (n+1) + num
        #考虑上述公式计算的数比tasks任务数少的特殊情况：
        if res < len(tasks):
            return len(tasks)
        return res
# @lc code=end

