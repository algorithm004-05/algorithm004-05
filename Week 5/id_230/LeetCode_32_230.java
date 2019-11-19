/**
*这题没仔细看清，犯错了，应该认真审题的，没有看到最长，
*导致后来添加了一下，可是还是有些情况不能通过，
*先附上自己的代码：
刚接触DP，所以找到状态数组，还是有欠缺。
*/
char[] arr = s.toCharArray();
        Map map = new HashMap();
        map.put('(', -1);
        map.put(')', 1);
        
        int left = 0, right = 0, near = 0, valid = 0, lastEdit = 0;
        List list = new ArrayList();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                left++; near = -1;
            } else {
                if (near == -1) {
//                    if (left > 0)
                    left--;
//                    valid++;
                    list.add(i);
                    if (left + right == 0) near =0;
                    else
                        near = (int)map.get(arr[left + right - 1]);
                } else {
                    right++;
                    near = 1;
                }
            }
        }
        System.out.println(list);

        if (list.isEmpty()) {
            return 0;
        } else if (list.size() == 1) {
            return 2;
        } else {
            for (int i = list.size() - 1; i > 0; i--) {
                if ((int)list.get(i) - (int)list.get(i - 1) <= 2) {
                    valid++;
                }
            }
            return 2 * (valid + 1);
        }

/**
附上题解

作者：LeetCode
链接：https://leetcode-cn.com/problems/longest-valid-parentheses/solution/zui-chang-you-xiao-gua-hao-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/
public int longestValidParentheses(String s) {
        int maxans = 0;
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }

