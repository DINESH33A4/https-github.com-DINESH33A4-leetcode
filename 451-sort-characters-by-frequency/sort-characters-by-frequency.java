class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();
        for(int i  = 0; i<s.length(); i++)  
            freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0)+1);
        PriorityQueue<mapping> pq = new PriorityQueue<>((a,b)->Integer.compare(b.freq, a.freq));
        for(Character i : freq.keySet())
            pq.add(new mapping(i, freq.get(i)));
        StringBuffer sb = new StringBuffer();
        while(!pq.isEmpty()){
            mapping m = pq.poll(); 
            sb.append(String.valueOf(m.ch).repeat(m.freq));
        }
        return sb.toString();
    }
}
class mapping{
    Character ch;
    int freq;
    public mapping(Character ch, int freq){
        this.ch = ch;
        this.freq = freq;
    }
}