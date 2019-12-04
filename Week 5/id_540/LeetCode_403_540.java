package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode_403_540 {
    public boolean canCross(int[] stones) {
        Map<Integer, Set<Integer>> dp = new HashMap();

        for (int stone : stones) {
            dp.put(stone, new HashSet<>());
        }
        dp.get(0).add(0);

        for (int i = 0; i < stones.length; i++) {
            int currentStone = stones[i];

            Set<Integer> previousMoves = dp.get(currentStone);

            if (previousMoves != null) {
                for (Integer previousMove : previousMoves) {
                    tryMove(dp, currentStone, previousMove);
                    tryMove(dp, currentStone, previousMove - 1);
                    tryMove(dp, currentStone, previousMove + 1);
                }
            }
        }

        return dp.get(stones[stones.length - 1]) != null && !dp.get(stones[stones.length - 1]).isEmpty();
    }

    private void tryMove(Map<Integer, Set<Integer>> dp, Integer currentPosition, Integer targetMove) {
        if (currentPosition + targetMove < 0 || currentPosition + targetMove == currentPosition) {
            return;
        }

        if (dp.get(currentPosition + targetMove) != null) {
            dp.get(currentPosition + targetMove).add(targetMove);
        }
    }
}
