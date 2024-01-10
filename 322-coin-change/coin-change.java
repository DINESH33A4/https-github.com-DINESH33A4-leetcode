class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        // Arrays.sort(coins);
        int[][] dp = new int[n][amount+1];
        for(int i = 0; i<=amount; i++){
            if(i%coins[0] == 0)
                dp[0][i] = i/coins[0];
            else
                dp[0][i] = 1000000007;
        }

        for(int i = 1; i<n; i++){
            for(int tar = 0; tar<=amount; tar++){
                int take = Integer.MAX_VALUE;
                if(coins[i] <= tar)
                    take = 1 + dp[i][tar- coins[i]];
                
                int notTake = dp[i-1][tar];
                dp[i][tar] = Math.min(take, notTake);
            }
        }
        return dp[n-1][amount]==1000000007?-1:dp[n-1][amount];
    }
    //     for(int[] i : dp)
    //         Arrays.fill(i, -1);
    //     int a = helper(n-1, amount, coins, dp);
    //     return a==1000000007?-1:a;
    // }
    // private static int helper(int n, int amount, int[] coins, int[][] dp){
    //     if(amount == 0)
    //         return 0;
    //     if(n==0)
    //         return amount%coins[n] == 0? amount/coins[n]:1000000007;

    //     if(dp[n][amount] != -1)
    //         return dp[n][amount];
    
    //     int take = Integer.MAX_VALUE;
    //     if(coins[n] <= amount)
    //         take = 1 + helper(n, amount-coins[n], coins, dp);
        
    //     int notTake = helper(n-1, amount, coins, dp);
    //     return dp[n][amount] = Math.min(take, notTake);

    // }
}