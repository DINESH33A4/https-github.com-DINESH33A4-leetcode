class Solution {
    public int maxLength(List<String> arr) {
        HashMap<String, Integer> memo = new HashMap<>();
        return helper(0, arr, new StringBuilder(), memo);
    }

    private static int helper(int idx, List<String> arr, StringBuilder dup, HashMap<String, Integer> memo) {
        if (idx == arr.size())
            return check(dup.toString()) ? dup.length() : 0;

        String key = idx + dup.toString();
        if (memo.containsKey(key))
            return memo.get(key);

       
        int includeCurrent = helper(idx + 1, arr, dup.append(arr.get(idx)), memo);
        dup.setLength(dup.length() - arr.get(idx).length());

        int excludeCurrent = helper(idx + 1, arr, dup, memo);

        int maxLength = Math.max(includeCurrent, excludeCurrent);
        memo.put(key, maxLength);

        return maxLength;
    }

    private static boolean check(String s) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++)
            if (!set.contains(s.charAt(i)))
                set.add(s.charAt(i));
            else
                return false;
        return true;
    }
}
