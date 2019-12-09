package geektime.greedy;

import java.util.HashSet;

public class RobootSim {
    public int robotSim(int[] commands, int[][] obstacles) {
        int x = 0;int y = 0;int placeNum = 0;int ultimateRange = 0;
        //用两个数组模拟机器人的走向，分为四个方向，沿x轴正向、x轴负向、y轴正向、y轴负向。初始方向是往y轴正向走。
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int direct = 0;
        HashSet<String> obstacleSet = new HashSet<String>();
        for (int i = 0; i < obstacles.length; i++) {
            obstacleSet.add(obstacles[i][0] + "," + obstacles[i][1]);
        }
        for (int i = 0; i < commands.length; i++) {
            if (commands[i] == -2) {
                direct--;
                if (direct < 0) direct = 3;
            } else if (commands[i] == -1) {
                direct++;
                if (direct > 3) direct = 0;
            }
            if (commands[i] != -2 && commands[i] != -1) {
                if (dx[direct] == 0) {
                    //沿y轴方向走，则逐步走，看走到当前命令的步数，是否会遇到障碍物
                    for (int j = 1; j <= commands[i]; j++) {
                        placeNum = y + j * dy[direct];
                        if (obstacleSet.contains(x + "," + placeNum)) {
                            y = y + dy[direct] * (j - 1);break;
                        }
                        if (j == commands[i]) y = placeNum;
                    }
                    ultimateRange = Math.max(ultimateRange,x*x + y*y);
                }
                if (dy[direct] == 0) {
                    //沿x轴方向走，则逐步走，看走到当前命令的步数，是否会遇到障碍物
                    for (int j = 1; j <= commands[i]; j++) {
                        placeNum = x + j * dx[direct];
                        if (obstacleSet.contains(placeNum + "," + y)) {
                            x = x + dx[direct] * (j - 1);break;
                        }
                        if (j == commands[i]) x = placeNum;
                    }
                    ultimateRange = Math.max(ultimateRange,x*x + y*y);
                }
            }
        }
        return ultimateRange;
    }
}
