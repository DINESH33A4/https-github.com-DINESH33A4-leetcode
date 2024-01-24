class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;
        int[] dp = new int[n];
        Arrays.sort(words, (a,b)->Integer.compare(a.length(), b.length()));
        Arrays.fill(dp, 1);
        int ans = 1;
        for(int i = 1; i<n; i++){
            for(int j = 0; j<i; j++){
                if(compare(words[i], words[j]) && dp[i] < dp[j]+1)
                    dp[i] = dp[j] + 1;
            }
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }
    private static boolean compare(String a, String b){
        if(a.length() - b.length() != 1) 
            return false;
        int i = 0, j = 0;
        while(i!=a.length() && j != b.length()){
            if(a.charAt(i) == b.charAt(j)){
                i++;
                j++;
            }
            else{
                i++;
            }
        }
        if(i==a.length() && j == b.length() || i == a.length()-1 && j == b.length())
            return true;
        return false;
        
    }
}