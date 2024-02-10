class Solution {
    public int countSubstrings(String s) {
        int ans = 0, n = s.length();
        for(int i = 0; i<n; i++){
            for(int j = i; j<n; j++){
                if(isPalindrome(i, j, s))
                    ans++;
            }
        }
        return ans;
    }
    private static boolean isPalindrome(int i, int j, String s){
        while(i<=j){
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}