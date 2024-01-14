class Solution {
    public int minDistance(String word1, String word2) {
        if(word1.length()==0)
            return word2.length();
        if(word2.length() == 0)
            return word1.length();
        int m = word1.length();
        int n = word2.length();
        int[] curr = new int[n+1];
        int[] prev = new int[n+1];
        prev[0] = 0;
        curr[0] = 0;
        for(int j = 0; j<=n; j++)
            prev[j] = j;
        for(int i = 1; i<=m; i++){
            curr = new int[n+1];
            curr[0] = i;
            for(int j = 1; j<=n; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    curr[j] = prev[j-1];
                }
                else{
                    curr[j] = 1 + Math.min(prev[j-1], Math.min(prev[j], curr[j-1]));
                }
            }
            prev = curr;
        }
        return curr[n];
    }
    //     int[][] dp = new int[m+1][n+1];
    //     for(int i = 0; i<=m; i++)
    //         dp[i][0] = i;
    //     for(int j = 0; j<=n; j++)
    //         dp[0][j] = j;
    //     for(int i = 1; i<=m; i++){
    //         for(int j = 1; j<=n; j++){
    //             if(word1.charAt(i-1) == word2.charAt(j-1)){
    //                 dp[i][j] = dp[i-1][j-1];
    //             }
    //             else{
    //                 dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
    //             }
    //         }
    //     }
    //     return dp[m][n];

    // }

    //     for(int i[] : dp)
    //         Arrays.fill(i, -1);
    //     return helper(m-1, n-1, word1, word2, dp);
    // }
    // private static int helper(int i, int j, String s, String t, int[][] dp){
    //     if(i<0)
    //         return j+1;
    //     if(j<0)
    //         return i+1;
    //     if(dp[i][j] != -1)
    //         return dp[i][j];
    //     if(s.charAt(i) == t.charAt(j))
    //         return dp[i][j] = helper(i-1, j-1, s, t, dp);
    //     else
    //         return dp[i][j] = 1 + Math.min(helper(i-1, j, s, t, dp), Math.min(helper(i, j-1, s, t, dp), helper(i-1, j-1, s, t, dp)));
    // }
}