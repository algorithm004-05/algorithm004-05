import java.util.HashSet;
import java.util.Set;

/**
 * 机器人在一个无限大小的网格上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令：
 *
 * -2：向左转 90 度
 * -1：向右转 90 度
 * 1 <= x <= 9：向前移动 x 个单位长度
 * 在网格上有一些格子被视为障碍物。
 *
 * 第 i 个障碍物位于网格点  (obstacles[i][0], obstacles[i][1])
 *
 * 如果机器人试图走到障碍物上方，那么它将停留在障碍物的前一个网格方块上，但仍然可以继续该路线的其余部分。
 *
 * 返回从原点到机器人的最大欧式距离的平方。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: commands = [4,-1,3], obstacles = []
 * 输出: 25
 * 解释: 机器人将会到达 (3, 4)
 * 示例 2：
 *
 * 输入: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
 * 输出: 65
 * 解释: 机器人在左转走到 (1, 8) 之前将被困在 (1, 4) 处
 *  
 *
 * 提示：
 *
 * 0 <= commands.length <= 10000
 * 0 <= obstacles.length <= 10000
 * -30000 <= obstacle[i][0] <= 30000
 * -30000 <= obstacle[i][1] <= 30000
 * 答案保证小于 2 ^ 31
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/walking-robot-simulation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_874_510 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_874_510().robotSim(new int[]{4,-1,4,-2,4},new int[][] {{2,4}}));
    }

    public int robotSim(int[] commands, int[][] obstacles) {
        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}}; //右 下 左 上
        int index = 0,x = 0,y = 0,max = 0,nextX=0,nextY=0;
        Set<String> set = new HashSet<>();
        for (int[] is : obstacles) {
            set.add(is[0] +"-" +is[1]);
        }
        for (int i = 0;i < commands.length;i++) {
            if(commands[i] >= 1 && commands[i] <=9){
                for (int j = 0; j < commands[i]; j++) {
                    nextX = x + dir[index][0];
                    nextY = y + dir[index][1];
                    if(set.contains(nextX +"-" + nextY)){
                        break;
                    }
                    x= nextX;
                    y= nextY;
                }
                max = Math.max(max, x*x + y* y);
            } else if(commands[i] == -1){
                index = (index+1)%4; 
            } else  if(commands[i] == -2){
                //dir0 = (dir0-1+ 4)%4;
                index = (index+3)%4; 
            } else {
                return 0;
            }
        }
        return max;
    }
}
