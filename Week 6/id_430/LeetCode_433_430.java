import java.util.*;

/**
 * Created by panda on 2019/11/25.
 */
public class LeetCode_433_430 {
    class Solution {
        public int minMutation(String start, String end, String[] bank) {
            Set<String> banks = new HashSet();
            for (String b : bank) {
                banks.add(b);
            }
            if (!banks.contains(end)) {
                return -1;
            }
            int n = start.length();
            int count = 0;
            char[] changes = new char[]{'A', 'C', 'G', 'T'};
            Set<String> set1 = new HashSet();
            Set<String> set2 = new HashSet();
            set1.add(start);
            set2.add(end);
            // 与普通BFS不同的是，这里不用先更新visited
            while (!set1.isEmpty() && !set2.isEmpty()) {
                // 从元素较少的地方开始
                // 刚开始个数都一样，之后会个数多少交替
                if (set1.size() > set2.size()) {
                    Set temp = set2;
                    set2 = set1;
                    set1 = temp;
                }
                Set<String> set = new HashSet();
                for (String s : set1) {
                    // 不能再被使用
                    banks.remove(s);
                    count++;
                    char[] arr = s.toCharArray();
                    for (int i = 0; i < n; i++) {
                        char tmp = arr[i];
                        for (char c : changes) {
                            arr[i] = c;
                            String str = new String(arr);
                            // 不需要加一，到此状态之前的步数已经算过
                            if (set2.contains(str)) {
                                return count;
                            }
                            if (banks.contains(str)) {
                                // 计划可能走某些路径，不一定真的走其中某步，因为有两端BFS，哪端先走属于哪端，所以这里不能更新visited
                                set.add(str);
                            }
                        }
                        // 恢复原来的数组
                        arr[i] = tmp;
                    }
                }
                // 相当于一个新的队列
                set1 = set;
            }
            return -1;
        }

    }
}
