class Solution {
    public int racecar(int target) {
        int[] dp = new int[target+1];
        return helper(target, dp);
    }

    private int helper(int target, int[] dp) {
        if (target == 0) {
            return 0;
        }
        if (dp[target] != 0) {
            return dp[target];
        }
        int forwardSteps = 1;
        int forwardDistance = 1;
        while (forwardDistance < target) {
            forwardDistance = (forwardDistance << 1) + 1;
            forwardSteps++;
        }
        if (forwardDistance == target) {
            dp[target] = forwardSteps;
            return forwardSteps;
        }
        forwardDistance = forwardDistance >> 1;
        forwardSteps--;
        int result = helper(target - forwardDistance, dp) + forwardSteps + 2;
        int backwardDistance = 1;
        int backwardSteps = 1;
        for (int i = 0;backwardSteps<forwardSteps;backwardSteps++, backwardDistance = (backwardDistance << 1) + 1) {
            result = Math.min(result, helper(target - forwardDistance + backwardDistance, dp) + forwardSteps + backwardSteps + 2);
        }
        forwardDistance = (forwardDistance << 1) + 1;
        forwardSteps++;
        result = Math.min(result, helper(forwardDistance - target, dp) + forwardSteps + 1);
        dp[target] = result;
        return result;
    }
}
