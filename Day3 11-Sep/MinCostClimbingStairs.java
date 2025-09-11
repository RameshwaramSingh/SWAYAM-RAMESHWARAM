//leetcode ques no 746
https://leetcode.com/problems/min-cost-climbing-stairs/

class Solution {
    int dp[];
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        //return solve1(n,cost);

        return solve2(cost);
    }

    // first appraoch using recursion and memoization(top-down appraoach)
    private int solve1(int n, int[] cost){
        if(n==0 || n==1) return 0;

        if(dp[n] != -1) return dp[n];

        int oneStep = solve1(n-1,cost) + cost[n-1];
        int twoStep = solve1(n-2,cost) + cost[n-2];

        return dp[n] = Math.min(oneStep,twoStep);
    }

    // second approach usinf tabulation method bottom up appraoch

    private int solve2(int[] cost){
        int n = cost.length;
        int dp2[] = new int[n+1];

        dp2[0] = 0;
        dp2[1] = 0;

        for(int i = 2;i<=n;i++){
            int oneStep = dp2[i-1]+cost[i-1];
            int twoStep = dp2[i-2] + cost[i-2];
            dp2[i] = Math.min(oneStep,twoStep);
        }
        return dp2[n];
    }
}
