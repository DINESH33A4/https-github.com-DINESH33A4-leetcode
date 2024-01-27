class Solution {
    static int mod = (int)1e9 + 7;
    public int kInversePairs(int n, int k) { // n 1e3 * k 1e3 * 1e3 ~ 1e9
        int[] prev = new int[k+1];
        int[] curr = new int[k+1];
        //n : 0 -> n
        //k : 0 -> k
        //k<0 ? 0
        prev[0] = 1; //n==0 k==0
        for(int i = 1; i<=n; i++){
            curr = new int[k+1];
            for(int j = 0; j<=k; j++){            
                int sum = 0;
                for(int m = 0; m<i && j - m >= 0; m++){
                    sum = (sum + prev[j - m]) % mod;
                }
                curr[j] = sum;
            }
            prev = curr;
        }
        return curr[k];
    }
    //     for(int[] i : dp)   Arrays.fill(i, -1);
    //     return check(n, k, dp);
    // }
    // private static int check(int n, int k, int[][] dp){
    //     if(n==0)    return k==0?1:0;
    //     if(k<0)     return 0;
    //     if(dp[n][k]!= -1)   return dp[n][k];

    //     int sum = 0;
    //     for(int i = 0; i<n; i++){
    //         sum = (sum + check(n-1, k - i, dp)) % mod;
    //     }
    //     return dp[n][k] = sum;
    // }

}