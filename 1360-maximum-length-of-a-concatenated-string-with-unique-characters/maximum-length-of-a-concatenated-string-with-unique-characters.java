class Solution {
    public int maxLength(List<String> arr) {
        HashMap<String, Integer> m = new HashMap<>();
        return helper(0, arr, "", m);
    }
    private static int helper(int idx, List<String>arr, String dup,HashMap<String,Integer> m){
        boolean checked = check(dup);
        if(!checked)
            return 0;
        if(idx == arr.size())
            return checked?dup.length():0;
        if(m.containsKey(idx+dup))
            return m.get(idx+dup);
        m.put(idx+dup, Math.max(helper(idx+1, arr, dup+arr.get(idx), m),
                                helper(idx+1, arr, dup, m)));
        return m.get(idx+dup);
    }

     private static boolean check(String s){
        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i<s.length(); i++)
            if(!set.contains(s.charAt(i)))
                set.add(s.charAt(i));
            else
                return false;
        return true;
    }
}