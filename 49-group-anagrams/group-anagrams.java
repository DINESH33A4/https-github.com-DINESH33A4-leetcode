class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String, List<String>> h = new HashMap<>();
        for(String i : strs){
            int[] cnt = new int[26];
            for(int j = 0; j<i.length(); j++){
                cnt[i.charAt(j) - 'a']++;
            }
            StringBuffer s = new StringBuffer();
            for(int j = 0; j<26; j++){
                if(cnt[j] != 0)
                    s.append(((char)('a' + j)) + "," + cnt[j]);
            }
            if(!h.containsKey(s.toString())){
                h.put(s.toString(), new ArrayList());
            }
            h.get(s.toString()).add(i);
        }
        for(String i : h.keySet()){
            ans.add(h.get(i));
        }
        return ans;
        
    }
}