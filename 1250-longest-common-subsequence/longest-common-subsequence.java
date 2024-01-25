class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[] prev = new int[n+1];
        int[] curr = new int[n+1];
        for(int i = 1; i<=m; i++){
            curr  = new int[n+1];
            for(int j = 1; j<=n; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1))
                    curr[j] = 1 + prev[j-1];
                else
                    curr[j] = Math.max(prev[j], curr[j-1]);
            }
            prev = curr;
        }
        return curr[n];

    }
    //     for(int[] i : dp)   
    //         Arrays.fill(i, -1);
    //     return lis(m-1, n-1, text1, text2, dp);
    // }
    // private static int lis(int i , int j, String text1, String text2, int[][] dp){
    //     if(i<0 || j<0)
    //         return 0;
    //     if(dp[i][j] != -1)
    //         return dp[i][j];
    //     if(text1.charAt(i) == text2.charAt(j))
    //         dp[i][j] = 1 + lis(i-1, j-1, text1, text2, dp);
    //     else
    //         dp[i][j] = Math.max(lis(i-1, j, text1, text2, dp), lis(i, j-1, text1, text2, dp));
    //     return dp[i][j];
    // }
}