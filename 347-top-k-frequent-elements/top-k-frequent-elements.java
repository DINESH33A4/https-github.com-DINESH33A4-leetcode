class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> m = new HashMap<>();
        for(int i : nums)   m.put(i, m.getOrDefault(i, 0)+1);
        // System.out.println(m);
        PriorityQueue<mapping> pq = new PriorityQueue<>((a,b)->Integer.compare(b.freq,a.freq));
        for(int i : m.keySet()){
            pq.add(new mapping(m.get(i), i));
        }
        // System.out.println(pq);
        int[] ans = new int[k];
        int i = 0;
        while(k-- > 0){
            ans[i++] = pq.poll().value;
        }
        return ans;
    }
}
class mapping{
    int freq;
    int value;
    public mapping(int freq, int value){
        this.freq = freq;
        this.value  = value;
    }
}