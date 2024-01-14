class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length())
            return false;
        int[] w1 = new int[26];
        int[] w2 = new int[26];
        HashSet<Character> s = new HashSet<>();
        for(int i = 0; i<word1.length(); i++){
            w1[word1.charAt(i)-'a']++;
            s.add(word1.charAt(i));
        }
        for(int i = 0; i<word1.length(); i++){
            w2[word2.charAt(i)-'a']++;
            if(!s.contains(word2.charAt(i)))
                return false;
        }
        Arrays.sort(w1);
        Arrays.sort(w2);
        for(int i = 0; i<26; i++){
            if(w1[i]!=w2[i])
                return false;
        }
        return true;
    }
}