// first approach using recursion + memoization

class Solution {
    int[] dp;

    public int maxSumMemo(int[] nums, int index) {
        if (index >= nums.length) return 0;
        if (dp[index] != -1) return dp[index];

        int include = nums[index] + maxSumMemo(nums, index + 2);
        int exclude = maxSumMemo(nums, index + 1);

        dp[index] = Math.max(include, exclude);
        return dp[index];
    }

    public int maxSumNonAdjacent(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return maxSumMemo(nums, 0);
    }

//Tabulation + Space Optimized (Bottom-Up DP)
  
  public int maxSumNonAdjacent(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int include = nums[0];
        int exclude = 0;

        for (int i = 1; i < nums.length; i++) {
            int newInclude = exclude + nums[i];
            int newExclude = Math.max(include, exclude);

            include = newInclude;
            exclude = newExclude;
        }

        return Math.max(include, exclude);
    }
}
