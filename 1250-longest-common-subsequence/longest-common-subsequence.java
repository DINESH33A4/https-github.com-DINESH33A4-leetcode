class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[] curr = new int[n+1];
        int[] prev = new int[n+1];
        for( int i = 1; i<=m; i++){
            curr = new int[n+1];
            for(int j = 1; j<=n; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1))
                    curr[j] = 1 + prev[j-1];
                else
                    curr[j] = Math.max(prev[j], curr[j-1]);
            }
            prev = curr;
        }
        return prev[n];
    }

    //     int[][] dp = new int[m+1][n+1];
    //     for(int i = 1; i<=m; i++){
    //         for(int j = 1; j<=n; j++){
    //             if(text1.charAt(i-1) == text2.charAt(j-1))
    //                 dp[i][j] = 1 + dp[i-1][j-1];
    //             else
    //                 dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
    //         }
    //     }
    //     return dp[m][n];
    // }


    //     for(int[] i : dp)y
    //         Arrays.fill(i, -1);
    //     return helper(m-1, n-1, text1, text2, dp);
    // }

    // private static int helper(int m, int n, String t1, String t2, int[][] dp){
    //     if(m<0||n<0)
    //         return 0;
    //     if(dp[m][n] != -1)
    //         return dp[m][n];
    //     if(t1.charAt(m)==t2.charAt(n))
    //         return dp[m][n] = 1 + helper(m-1, n-1, t1, t2, dp);
    //     else 
    //         return dp[m][n] = Math.max(helper(m-1, n, t1, t2, dp), helper(m, n-1, t1, t2, dp));
    // }
}