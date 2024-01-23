import java.util.HashSet;
import java.util.List;

class Solution {
    public int maxLength(List<String> arr) {
        return backtrack(arr, 0, "");
    }

    private int backtrack(List<String> arr, int index, String current) {
        if (!isUnique(current)) {
            return 0;
        }

        int maxLen = current.length();

        for (int i = index; i < arr.size(); i++) {
            maxLen = Math.max(maxLen, backtrack(arr, i + 1, current + arr.get(i)));
        }

        return maxLen;
    }

    private boolean isUnique(String s) {
        HashSet<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (!set.add(c)) {
                return false;
            }
        }
        return true;
    }
}
