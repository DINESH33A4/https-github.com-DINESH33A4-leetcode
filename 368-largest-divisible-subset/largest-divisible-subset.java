class Solution {
    public List<Integer> largestDivisibleSubset(int[] arr) {
        int x = arr.length;
        int[] dp = new int[x];
        int[] hash = new int[x];
        int lastIndex = 0;
        int maxi = 1;
        Arrays.sort(arr) ;
        Arrays.fill(dp, 1);
        for(int i = 1; i<x; i++){
            hash[i] = i;
            for(int j = 0; j<i; j++){
                if(arr[i] % arr[j] == 0 && dp[i] < dp[j]+1){
                    dp[i] = dp[j] + 1;
                    hash[i] = j;
                }
            }
            if(maxi < dp[i]){
                lastIndex = i;
                maxi = dp[i];
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(hash[lastIndex] != lastIndex){
            ans.add(arr[lastIndex]);
            lastIndex = hash[lastIndex];
        }
        ans.add(arr[lastIndex]);
        Collections.reverse(ans);
        // System.out.println(ans);
        return ans;
    }
}