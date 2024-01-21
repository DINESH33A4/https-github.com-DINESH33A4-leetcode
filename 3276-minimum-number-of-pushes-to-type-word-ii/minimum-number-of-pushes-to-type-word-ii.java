import java.util.*;
class Solution {
    public int minimumPushes(String word) {
        int[][] freq = new int[26][2];
        for(int i = 0;i<26; i++)
            freq[i][1] = i;
        for(int i = 0; i<word.length(); i++){
            int ch = word.charAt(i) - 'a';
            freq[ch][0]++;
        }
         Arrays.sort(freq, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(b[0], a[0]);
        });
        HashMap<Integer, Integer> m = new HashMap<>();
        for(int i = 0; i<26; i++){
            if(freq[i][0] <= 0)
                continue;
            if(i<8){ 
                int ch = 'a' + freq[i][1]; 
                m.put(ch, 1);
            }
            else if(i<16){
                int ch = 'a' + freq[i][1]; 
                m.put(ch, 2);
            }
            else if(i<24){
                int ch = 'a' + freq[i][1]; 
                m.put(ch, 3);
            }
            else if(i>=24){
                int ch = 'a' + freq[i][1]; 
                m.put(ch, 4);
            }
        }
        int ans = 0;
        for(int i = 0; i<word.length(); i++){
            int c = word.charAt(i);
            if(m.containsKey(c))
            ans += m.get(c);
        }
        return ans;
    }
   
}