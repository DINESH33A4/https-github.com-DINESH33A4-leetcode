class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int a1,a2,b1,b2;
        a1=a2=b1=b2=0;
        for(int i = n-1; i>=0; i--){
            a1 = Math.max(prices[i] + b2, b1);
            a2 = Math.max(- fee - prices[i] + b1, b2);
            b1 = a1;
            b2 = a2;
        }
        return a2;
    }

    //     int[][] dp = new int[n][2];
    //     for(int[] i : dp)
    //         Arrays.fill(i, -1);
    //     return helper(0, 1, fee, prices, dp);
    // }
    // private static int helper(int i, int buy, int fee, int[] prices, int[][] dp){
    //     if(i==prices.length)
    //         return 0;
    //     if(dp[i][buy] != -1)
    //         return dp[i][buy];
    //     if(buy == 1){
    //         return dp[i][buy] = Math.max(-prices[i] - fee + helper(i+1, 0, fee, prices, dp), helper(i+1, 1, fee, prices, dp));
    //     }
    //     else{
    //         return dp[i][buy] = Math.max(prices[i] + helper(i+1, 1, fee, prices, dp), helper(i+1, 0, fee, prices, dp));
    //     }
    // }
}