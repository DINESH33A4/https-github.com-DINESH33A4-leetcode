class Solution {
    public int firstUniqChar(String s) {
        int ans = Integer.MAX_VALUE;
        for(int i = 'a'; i<='z'; i++){
            int x = s.indexOf(i);
            if(x!=-1 && s.lastIndexOf(i) == x)
                ans = Math.min(ans, x);
        }
        return ans == Integer.MAX_VALUE?-1:ans;

        // int[] map = new int[26];
        // for(int i = s.length() -1; i>=0; i--){
        //     map[s.charAt(i) - 'a']++;
        // }
        // for(int i = 0; i<s.length(); i++){
        //     if(map[s.charAt(i) - 'a'] == 1)
        //         return i;
        // }
        // return -1;
    }
}