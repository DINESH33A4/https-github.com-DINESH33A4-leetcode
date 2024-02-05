class Solution {
    public int firstUniqChar(String s) {
        int[] map = new int[26];
        for(int i = s.length() -1; i>=0; i--){
            map[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i<s.length(); i++){
            if(map[s.charAt(i) - 'a'] == 1)
                return i;
        }
        return -1;
    }
}