class Solution {
    public boolean halvesAreAlike(String s) {
        int one=0, two=0;
        for(int i = 0; i<s.length()/2; i++)
            if(isVowel(s.charAt(i)))
                one++;
        for(int i = s.length()/2; i<s.length(); i++)
            if(isVowel(s.charAt(i)))
                two++;
        return one==two;    
    }
    private boolean isVowel(char a){
        return (a=='a'||a=='A'||a=='e'||a=='E'||a=='i'||a=='I'||a=='o'||a=='O'||a=='u'||a=='U');
    }
}