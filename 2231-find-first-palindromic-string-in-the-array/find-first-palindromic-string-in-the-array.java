class Solution {
    public String firstPalindrome(String[] words) {
        for(String i : words)
            if(check(i))
                return i;
        return "";
    }
    static boolean check(String s){
        int i = 0;
        int j = s.length() - 1;
        while(i<=j){
            if(s.charAt(i++) != s.charAt(j--))
                return false;
        }
        return true;
    }
}