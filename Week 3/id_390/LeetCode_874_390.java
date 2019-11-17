//机器人在一个无限大小的网格上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令： 
//
// 
// -2：向左转 90 度 
// -1：向右转 90 度 
// 1 <= x <= 9：向前移动 x 个单位长度 
// 
//
// 在网格上有一些格子被视为障碍物。 
//
// 第 i 个障碍物位于网格点 (obstacles[i][0], obstacles[i][1]) 
//
// 如果机器人试图走到障碍物上方，那么它将停留在障碍物的前一个网格方块上，但仍然可以继续该路线的其余部分。 
//
// 返回从原点到机器人的最大欧式距离的平方。 
//
// 
//
// 示例 1： 
//
// 输入: commands = [4,-1,3], obstacles = []
//输出: 25
//解释: 机器人将会到达 (3, 4)
// 
//
// 示例 2： 
//
// 输入: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
//输出: 65
//解释: 机器人在左转走到 (1, 8) 之前将被困在 (1, 4) 处
// 
//
// 
//
// 提示： 
//
// 
// 0 <= commands.length <= 10000 
// 0 <= obstacles.length <= 10000 
// -30000 <= obstacle[i][0] <= 30000 
// -30000 <= obstacle[i][1] <= 30000 
// 答案保证小于 2 ^ 31 
// 
// Related Topics 贪心算法



//leetcode submit region begin(Prohibit modification and deletion)
// 1. 贪心算法 时间O(n*m) 空间O(m)
class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        Set<Long> obstacleSet = new HashSet<Long>();
        for (int[] obs : obstacles) {
            long obx = (long)obs[0] + 30000;
            long oby = (long)obs[1] + 30000;
            obstacleSet.add((obx << 16) + oby); // 加法比位运算优先
        }

        int ans = 0;
        int x = 0, y = 0, di = 0;
        for (int command : commands) {
            if (command == -2) {
                di = (di + 3) % 4;
            } else if (command == -1) {
                di = (di + 1) % 4;
            } else {
                for (int i = 0; i < command; i++) {
                    int nx = dx[di] + x;
                    int ny = dy[di] + y;
                    long code = (((long)nx + 30000) << 16) + ((long)ny + 30000);
                    if (!obstacleSet.contains(code)) {
                        x = nx;
                        y = ny;
                        ans = Math.max(ans, x * x + y * y);
                    }
                }

            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
