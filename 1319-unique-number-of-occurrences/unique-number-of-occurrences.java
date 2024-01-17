class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> m = new HashMap<>();
        for(int i :arr)
            m.put(i, m.getOrDefault(i, 0) + 1);
        HashSet<Integer> s = new HashSet<>();
        for(int i : m.values())
            if(!s.contains(i))
                s.add(i);
            else
                return false;
        return true;
    }
}