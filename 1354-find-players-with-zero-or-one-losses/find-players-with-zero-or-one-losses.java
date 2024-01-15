class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer, Integer> m = new HashMap<>();
        HashSet<Integer> h1 = new HashSet<>();
        HashSet<Integer> h2 = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());
        for(int[] i : matches){
            m.put(i[1], m.getOrDefault(i[1], 0)+1);
        }
        for(int i[] : matches){
            if(!m.containsKey(i[0])){
                h1.add(i[0]);
            }
            if(m.get(i[1]) == 1){
                h2.add(i[1]);
            }
        }
        ans.get(0).addAll(h1);
        ans.get(1).addAll(h2);
        Collections.sort(ans.get(0));
        Collections.sort(ans.get(1));
        return ans;
    }
}