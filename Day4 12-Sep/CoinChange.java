// leetcode ques no 322
https://leetcode.com/problems/coin-change/description/

class Solution {
    int[] memo;
    public int coinChange(int[] coins, int amount) {
        memo = new int[amount+1];
        Arrays.fill(memo,-2); // -2 means unvisited
        //return helper(coins,amount);
        return tabulation(coins,amount);
    }

    //Memoization (Top_Down Appraoch)
    private int helper(int[] coins, int amount){
        if(amount<0) return -1;

        if(amount == 0) return 0;

        if(memo[amount] != -2) return memo[amount]; // means visited

        int min = Integer.MAX_VALUE;
        for(int coin: coins){
            int res = helper(coins,amount-coin);
            if(res>=0 && res<min){
                min = 1+res;
            } 
        }
        memo[amount] = (min == Integer.MAX_VALUE)?-1:min;

        return memo[amount];
    }

    // Tabulation appraoch(bottom up)

    private int tabulation(int coins[], int amount){
        int max = amount+1;
        int dp [] = new int[amount+1];
        Arrays.fill(dp,max);
        dp[0] = 0; // base case: 0 coins needed to make 0 amount
        for(int i = 1;i<=amount;i++){
            for(int coin: coins){
                if(i-coin>=0){
                    dp[i] = Math.min(dp[i],dp[i-coin]+1);
                }
            }
        }
        return dp[amount]>amount?-1:dp[amount];
    }
}
