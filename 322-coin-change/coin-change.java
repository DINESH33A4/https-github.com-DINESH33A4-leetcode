class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        // Arrays.sort(coins);
        int[][] dp = new int[n][amount+1];
        for(int[] i : dp)
            Arrays.fill(i, -1);
        int a = helper(n-1, amount, coins, dp);
        return a==1000000007?-1:a;
    }
    private static int helper(int n, int amount, int[] coins, int[][] dp){
        if(amount == 0)
            return 0;
        if(n==0)
            return amount%coins[n] == 0? amount/coins[n]:1000000007;

        if(dp[n][amount] != -1)
            return dp[n][amount];
    
        int take = Integer.MAX_VALUE;
        if(coins[n] <= amount)
            take = 1 + helper(n, amount-coins[n], coins, dp);
        
        int notTake = helper(n-1, amount, coins, dp);
        return dp[n][amount] = Math.min(take, notTake);

    }
}