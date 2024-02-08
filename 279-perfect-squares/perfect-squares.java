class Solution {
    public int numSquares(int n) {
        ArrayList<Integer> al = generatePs(n);
        int size = al.size();
        int[][] dp = new int[size][n+1];
        System.out.println(al);
        for(int i[] : dp)
            Arrays.fill(i, -1);
        return helper(size-1, n, dp, al);
    }
    private static int helper(int i, int n, int[][] dp, ArrayList<Integer> al){
        if(n==0)
            return 0;
        if(i==0)
            return n % al.get(i) == 0 ? n / al.get(i) : 1000000007;   
        if(dp[i][n]!=-1)
            return dp[i][n];
        int take = Integer.MAX_VALUE;
        if(al.get(i) <= n){
            take = 1 + helper(i, n - al.get(i), dp, al);
        }
        int notTake = helper(i-1, n, dp, al);
        return dp[i][n] = Math.min(take, notTake);
        
    }
    private static ArrayList<Integer> generatePs(int n){
        ArrayList<Integer> al = new ArrayList<>();
        int i = 1;
        while(i*i <= n){
            al.add(i*i);
            i++;
        }
        return al;
    }
}